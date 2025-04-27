package org.ankanchanda.companyms.company;

import java.util.List;

import org.ankanchanda.companyms.dto.CompanyWithReviewsDTO;
import org.ankanchanda.companyms.dto.ReviewMessage;

public interface CompanyService {

    List<CompanyWithReviewsDTO> findAll();

    CompanyWithReviewsDTO findCompanyById(Long id);

    void createCompany(Company company);

    boolean deleteCompanyById(Long id);

    boolean updateCompany(Long id, Company company);

    public void updateCompanyRating(ReviewMessage reviewMessage);
}
