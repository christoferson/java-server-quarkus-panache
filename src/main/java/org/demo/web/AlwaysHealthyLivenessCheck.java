package org.demo.web;

import java.util.Date;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@ApplicationScoped
@Liveness // curl localhost:8080/q/health/live
public class AlwaysHealthyLivenessCheck implements HealthCheck {
	@Override //call() method is invoked whenever the /q/health/live endpoint is invoked
	public HealthCheckResponse call() {
		return HealthCheckResponse
				.named("Always live")
				.withData("time", String.valueOf(new Date()))
				.up()
				.build();
	}
}
