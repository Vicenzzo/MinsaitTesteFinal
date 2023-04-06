package com.minsait.financas.testefinalfinancas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/banco/health-check")
public class HealthController {
	@GetMapping
    public long health() {
		return System.currentTimeMillis();
	}
	
	@GetMapping("/vicenzzo")
	public long health2() {
		return System.currentTimeMillis();
	}
}
