package com.construction.systems.constech.company.api;

import com.construction.systems.constech.shared.exception.InternalServerErrorException;
import com.construction.systems.constech.company.domain.model.entities.Company;
import com.construction.systems.constech.company.domain.service.CompanyService;
import com.construction.systems.constech.company.mapping.CompanyMapper;
import com.construction.systems.constech.company.resource.CreateCompanyResource;
import com.construction.systems.constech.company.resource.CompanyResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Tag(name = "Data", description = "Everything about your Companies")
@AllArgsConstructor
@RestController
@RequestMapping("data")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = {"Content-Type", "Authorization"},methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,RequestMethod.PUT})
public class CompanyController {
    private final CompanyService CompanyService;

    private final CompanyMapper CompanyMapper;

    @Operation(
            summary = "Add a new Company to the constech" ,
            description = "Add a new Company to the constech",
            operationId = "addCompany",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CompanyResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @PostMapping
    public ResponseEntity<CompanyResource> save(@RequestBody CreateCompanyResource company) {
        return new ResponseEntity<>(
                CompanyMapper.toResource(CompanyService.save(CompanyMapper.toEntity(company))),
                HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Companies to the constech" ,
            description = "Get Companies to the constech",
            operationId = "getCompany",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CompanyResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @GetMapping
    public List<Company> fetchAll() {
        return CompanyService.fetchAll();
    }

    @Operation(
            summary = "Delete Company from the constech" ,
            description = "Delete Company from the constech",
            operationId = "deleteCompany",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CompanyResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") Integer id) {
        if (CompanyService.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        throw new InternalServerErrorException("Student", "id", String.valueOf(id), "deleted");
    }

    @Operation(
            summary = "Put Company to the constech" ,
            description = "Put Company to the constech",
            operationId = "putCompany",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Successful operation",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CompanyResource.class)
                            )
                    ),
                    @ApiResponse (
                            responseCode = "400",
                            description = "Bad Request",
                            content = @Content (
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = RuntimeException.class)
                            )
                    )
            }
    )
    @PutMapping("{id}")
    public ResponseEntity<CompanyResource> update(@PathVariable("id") Integer id, @RequestBody Company request) {
        Company updatedCompany = CompanyService.update(id, request);
        return ResponseEntity.ok(CompanyMapper.toResource(updatedCompany));
    }



    @GetMapping("companyName/{companyName}")
    public ResponseEntity<Company> fetchCompanyName(@PathVariable("companyName") String moneda){
        return ResponseEntity.ok(CompanyService.fetchByMoneda(moneda));
    }
}
