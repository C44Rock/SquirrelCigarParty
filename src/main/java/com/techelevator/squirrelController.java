package com.techelevator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.model.JdbcReviewDao;
import com.techelevator.model.Review;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Controller
public class squirrelController {
	
	DataSource dataSource;
	
	@Autowired
	public squirrelController(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public String displayHomeReviews(HttpServletRequest request) {
		
		JdbcReviewDao dao = new JdbcReviewDao(dataSource);
		
		List<Review> reviews = dao.getAllReviews();
		request.setAttribute("reviews", reviews);

		return "home";
	}
	
	@RequestMapping(path = "/reviews", method = RequestMethod.GET)
	public String displayReviewEntryPage() {
		return "reviews";
	}
	
	@RequestMapping(path = "/reviews", method = RequestMethod.POST)
	public String processForumPost(@RequestParam String username,
									@RequestParam int rating,
									@RequestParam String title,
									@RequestParam String text) {
		
		JdbcReviewDao dao = new JdbcReviewDao(dataSource);
		
		Review review = new Review();
		review.setTitle(title);
		review.setUsername(username);
		review.setRating(rating);
		review.setText(text);
		review.setDateSubmitted(LocalDateTime.now());
		
		dao.save(review);
		
		return "redirect:/home";
	}
	
	
}
