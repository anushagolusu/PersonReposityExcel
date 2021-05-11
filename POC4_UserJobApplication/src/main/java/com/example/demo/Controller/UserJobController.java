package com.example.demo.Controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Dao.JobRepo;
import com.example.demo.Model.Job;
import com.example.demo.Model.User;
import com.example.demo.Service.UserJobService;



@RestController
@RequestMapping("/userJob")
public class UserJobController {

	@Autowired
	UserJobService service;

	@Autowired
	JobRepo jobRepo;

	private JpaRepository<Job, Integer> userRepo;

	@PostMapping("/createUser")
	public User createUser(@RequestBody User user) {
		return service.createUser(user);
	}
	public Job createJob(Job job) {
		return jobRepo.save(job);
	}

	public Optional<Job> getJobById(int jobid) {
		return jobRepo.findById(jobid);
	}

	// get Job by Type
	public List<Job> getJobByType(String type) {
		return jobRepo.findByJobType(type);
	}

	// get Job by Experience
	public List<Job> getJobByExp(int exp) {
		return jobRepo.findByExperience(exp);
	}

	// Filter Job by Country:
	public List<Job> getJobBycountry(String country) {
		return jobRepo.findByCountry(country);
	}

	// Filter Job by Availability
	public List<Job> getJobByavailability(String availability) {
		return jobRepo.findByAvailability(availability);
	}

	// -> Filter Job by Skills:

	// getting user
	public List<Job> getAllUser() {
		return userRepo.findAll();
	}

	// getting Job
	public Iterable<Job> getJob(Job job) {
		return jobRepo.findAll();
	}

	public List<Job> createJobs(List<Job> job) {
		return jobRepo.saveAll(job);
	}
}
	