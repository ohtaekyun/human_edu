package com.human.springboot;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
	@Mapper
	public interface postDAO {
		void insertPosting(String title, String content, String writer);
		void listPosting(int one, String two, String three, String four, String five);
		ArrayList<PostingDTO> listPosting();
		PostingDTO getPost(int post_id);
		void deletePosting(int post_id);
		PostingDTO updatePosting(int post_id);
		void modifyPosting(int post_id, String two, String three);
}
