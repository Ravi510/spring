package in.apssdc.spark;

import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import in.apssdc.spark.dao.EmployeeDAO;
import in.apssdc.spark.security.model.Employee;
import in.apssdc.spark.security.model.Response;
import spark.Spark;

public class Application
{
	public static String firstName = "";
	public static String lastName = "";
	public static String display = "";
	public static String employeeId = "";
	static Response res = new Response();
	public static ApplicationContext ctx = new ClassPathXmlApplicationContext("springContext.xml");

	static EmployeeDAO dao = (EmployeeDAO) ctx.getBean("edao");
	static Template resultTemplate;

	public static void main(String[] args)
	{
		final Configuration configuration = new Configuration(new Version(2, 3, 0));
		configuration.setClassForTemplateLoading(Application.class, "/");
		Spark.staticFileLocation("/static");
		get("/", (request, response) -> {

			StringWriter writer = new StringWriter();

			try
			{
				Template formTemplate = configuration.getTemplate("templates/form.ftl");

				formTemplate.process(null, writer);
			}
			catch (Exception e)
			{
				Spark.halt(500);
			}
			return writer;
		});

		get("/stats", (req, res) -> true);
		get("/getAll", (request, response) -> {
			StringWriter writer = new StringWriter();
			Map<String, Object> map = new HashMap<String, Object>();
			try
			{
				List<Map<String, Object>> list = dao.getAll();
				if (list != null)
				{
					map.put("employees", list);
					resultTemplate = configuration.getTemplate("templates/report.ftl");
					resultTemplate.process(map, writer);
				}
				else
				{
					res.setSuccessful(false);
					res.setResponseObject(list);
					res.setErrorMessage("No data found!");
				}
			}

			catch (Exception e)
			{
				System.out.println("Exception: " + e);
			}
			return writer;
		});

		post("/add", (request, response) -> {
			StringWriter writer = new StringWriter();
			try
			{
				firstName = request.queryParams("firstName");
				lastName = request.queryParams("lastName");
				employeeId = request.queryParams("id");
				int status = dao.saveEmployee(new Employee(firstName, lastName, employeeId));
				if (status != 0)
				{
					resultTemplate = configuration.getTemplate("templates/success.ftl");
					resultTemplate.process(null, writer);
				}
				else
				{
					resultTemplate = configuration.getTemplate("templates/fail.ftl");
					resultTemplate.process(null, writer);
				}
			}

			catch (Exception e)
			{
				System.out.println("Exception: " + e);
			}
			return writer;
		});
		// https://1glpusftua.execute-api.us-west-2.amazonaws.com/RaviTestStage/ravitest
		put("/update", (request, response) -> {
			StringWriter writer = new StringWriter();
			try
			{
				firstName = request.queryParams("firstName");
				lastName = request.queryParams("lastName");
				employeeId = request.queryParams("id");
				int status = dao.updateEmployee(new Employee(firstName, lastName, employeeId));
				if (status != 0)
				{
					resultTemplate = configuration.getTemplate("templates/success.ftl");
					resultTemplate.process(null, writer);
				}
				else
				{
					resultTemplate = configuration.getTemplate("templates/fail.ftl");
					resultTemplate.process(null, writer);
				}
			}

			catch (Exception e)
			{
				System.out.println("Exception: " + e);
			}
			return writer;
		});

		delete("/remove", (request, response) -> {
			StringWriter writer = new StringWriter();
			try
			{
				firstName = request.queryParams("firstName");
				lastName = request.queryParams("lastName");
				employeeId = request.queryParams("id");
				int status = dao.deleteEmployee(new Employee(firstName, lastName, employeeId));
				if (status != 0)
				{
					resultTemplate = configuration.getTemplate("templates/success.ftl");
					resultTemplate.process(null, writer);
				}
				else
				{
					resultTemplate = configuration.getTemplate("templates/fail.ftl");
					resultTemplate.process(null, writer);
				}
			}

			catch (Exception e)
			{
				System.out.println("Exception: " + e);
			}
			return writer;
		});
	}
}