package com.crap.the.cut.api;

import java.util.List;

import javax.net.ssl.SSLEngineResult.Status;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import com.crap.the.cut.dao.entities.Tags;
import com.crap.the.cut.dao.entities.TagsDAO;

/**
 * @author mayank
 *
 */
@Path("/tags")
public class TagsRestApi {

	@Path("/all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllTags()
	{
		JSONObject data = new JSONObject(); 
		JSONArray tagsArray = new JSONArray();
		List<Tags> tags = new TagsDAO().findAll();
		if(tags.size()>0)
		{
			for(Tags tag : tags)
			{
				if(tag.getIsActive()!=null && tag.getIsActive())
				{
					JSONObject tagObject = new JSONObject();
					tagObject.put("id", tag.getId());
					tagObject.put("name", tag.getTagName());
					tagObject.put("weight", tag.getWeight());
					tagObject.put("url", tag.getUrl());
					tagsArray.put(tagObject);	
				}
				
			}
		}
		data.put("data", tagsArray);
		return Response.ok(data.toString()).status(200).build();
	}
}
