package com.example.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.JobRepo;
import com.example.demo.Dao.UserRepo;
import com.example.demo.Model.Job;
import com.example.demo.Model.User;

@Service
	public class UserJobService {

		@Autowired
		UserRepo userRepo;

		@Autowired
		JobRepo jobRepo;

		public User createUser(User user) {
			return userRepo.save(user);
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
		public Iterable<User> getAllUser() {
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
