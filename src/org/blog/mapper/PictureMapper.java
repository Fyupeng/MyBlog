package org.blog.mapper;

import java.util.List;
import java.util.Map;

import org.blog.entity.Picture;


public interface PictureMapper {
	
	public int queryPictureIsExistByPictureid(int pictureid);
	
	public abstract List<Picture> queryPictureByUserid(int userid);
	
	public abstract void addPictureWithUserid(Map<String, Object> params);
	
	public abstract void deletePictureByPircturenameWithUserid(Map<String, Object> params);
	
	public abstract int queryPictureIsExistByPicturename(String picturename);
	
}
