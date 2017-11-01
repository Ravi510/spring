package in.apssdc.spark.security.model;

import java.io.Serializable;

import in.apssdc.spark.utils.JsonUtils;

/**
 * 
 * @author Prakash K
 * @date 29-Aug-2015
 *
 */
public class BaseModel implements Serializable
{
	@Override
	public String toString()
	{
		return JsonUtils.toString(this);
	}
}
