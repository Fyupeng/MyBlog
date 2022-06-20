package org.blog.Util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.blog.entity.Picture;
import org.blog.mapper.PictureMapper;

public class PictureUtil {
	
	
	
	public boolean queryPictureIsExistByPictureid(int pictureid) {
		SqlSession session = MyBatisFactory.getSession();
		
		PictureMapper pictureMapper = session.getMapper(PictureMapper.class);
		
		
		
		int result = pictureMapper.queryPictureIsExistByPictureid(pictureid);
		
		session.commit();
		session.close();
		
		if(result == 1) {
			return true;
		}
		
		return false;
		
	}
	
	public List<Picture> queryPictureByUserid(int userid) {
		SqlSession session = MyBatisFactory.getSession();
		
		PictureMapper pictureMapper = session.getMapper(PictureMapper.class);
		
		
		
		List<Picture> pictures = pictureMapper.queryPictureByUserid(userid);
		
		session.close();
		
		return pictures;
	}
	
	public boolean queryPictureIsExistByPicturename(String picturename) {
		SqlSession session = MyBatisFactory.getSession();
		
		PictureMapper pictureMapper = session.getMapper(PictureMapper.class);
		
		int result = pictureMapper.queryPictureIsExistByPicturename(picturename);
		
		session.close();
		
		if(result != 0) {
			return true;
		}
		
		return false;
	}
	
	public void addPictureByUserid(int pictureid, String picturename, String pictureroute, int userid) {
		SqlSession session = MyBatisFactory.getSession();
		
		PictureMapper pictureMapper = session.getMapper(PictureMapper.class);
		
		Map<String, Object> pictureParams = new HashMap<>();
		
		pictureParams.put("pictureid", pictureid);
		pictureParams.put("picturename", picturename);
		pictureParams.put("pictureroute", pictureroute);
		pictureParams.put("userid", userid);
		
		pictureMapper.addPictureWithUserid(pictureParams);
		
		session.commit();
		session.close();
		
	}
	
	
	public void deletePictureByPircturenameWithUserid(String picturename, int userid) {
		SqlSession session = MyBatisFactory.getSession();
		
		PictureMapper pictureMapper = session.getMapper(PictureMapper.class);
		
		Map<String, Object> pictureParams = new HashMap<>();
		
		pictureParams.put("picturename", picturename);
		pictureParams.put("userid", userid);
		
		pictureMapper.deletePictureByPircturenameWithUserid(pictureParams);
		
		session.commit();
		session.close();
		
	}
	
}
