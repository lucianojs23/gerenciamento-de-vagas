package com.sistemavagas.gerenciamentoVagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemavagas.gerenciamentoVagas.modules.company.entities.JobEntity;
import com.sistemavagas.gerenciamentoVagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
	
	@Autowired
	private JobRepository jobRepository;
	
	public JobEntity execute(JobEntity jobEntity) {
		return this.jobRepository.save(jobEntity);
		

	}
}
