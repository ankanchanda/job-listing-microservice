package org.ankanchanda.jobms.clients;

import org.ankanchanda.jobms.external.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANYMS", url = "${companyService.url}")
public interface CompanyClient {

    @GetMapping("/companies/{id}")
    Company getCompany(@PathVariable Long id);
}
