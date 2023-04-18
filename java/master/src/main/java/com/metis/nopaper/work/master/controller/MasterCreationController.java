package com.metis.nopaper.work.master.controller;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metis.nopaper.work.master.dto.CategoryDTO;
import com.metis.nopaper.work.master.dto.CityDTO;
import com.metis.nopaper.work.master.dto.CountryDTO;
import com.metis.nopaper.work.master.dto.CurrencyDTO;
import com.metis.nopaper.work.master.dto.DeliveryTermsDTO;
import com.metis.nopaper.work.master.dto.DepartmentDTO;
import com.metis.nopaper.work.master.dto.IndustryTypeDTO;
import com.metis.nopaper.work.master.dto.MarketStrategyDTO;
import com.metis.nopaper.work.master.dto.NatureOfBusinessDTO;
import com.metis.nopaper.work.master.dto.OrganizationTypeDTO;
import com.metis.nopaper.work.master.dto.ProductDTO;
import com.metis.nopaper.work.master.dto.ProductSpecificationDTO;
import com.metis.nopaper.work.master.dto.StateDTO;
import com.metis.nopaper.work.master.dto.SubCategoryDTO;
import com.metis.nopaper.work.master.dto.TimeZoneDTO;
import com.metis.nopaper.work.master.dto.UnitDTO;
import com.metis.nopaper.work.master.models.Category;
import com.metis.nopaper.work.master.models.City;
import com.metis.nopaper.work.master.models.Country;
import com.metis.nopaper.work.master.models.Currency;
import com.metis.nopaper.work.master.models.DeliveryTerms;
import com.metis.nopaper.work.master.models.Department;
import com.metis.nopaper.work.master.models.IndustryType;
import com.metis.nopaper.work.master.models.MarketStrategy;
import com.metis.nopaper.work.master.models.NatureOfBusiness;
import com.metis.nopaper.work.master.models.OrganizationType;
import com.metis.nopaper.work.master.models.Product;
import com.metis.nopaper.work.master.models.ProductSpecification;
import com.metis.nopaper.work.master.models.State;
import com.metis.nopaper.work.master.models.SubCategory;
import com.metis.nopaper.work.master.models.TimeZone;
import com.metis.nopaper.work.master.models.Unit;
import com.metis.nopaper.work.master.services.IMasterService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("${v1API}")
@Validated
public class MasterCreationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterCreationController.class);
	
	@Autowired
	private IMasterService masterService;
	
	@Autowired
	private ModelMapper mapper;
	
	@PostMapping(value = { "createCategory" }, produces = "application/json")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody @Valid CategoryDTO categoryDTO) throws Exception {
		
		Category postRequest = mapper.map(categoryDTO, Category.class);
		Category category = masterService.createCategory(postRequest);
		CategoryDTO postResponse = mapper.map(category, CategoryDTO.class);

		return new ResponseEntity<CategoryDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createSubCategory" }, produces = "application/json")
	public ResponseEntity<SubCategoryDTO> createSubCategory(@RequestBody @Valid SubCategoryDTO subCategoryDTO) throws Exception {
		
		SubCategory postRequest = mapper.map(subCategoryDTO, SubCategory.class);
		SubCategory subCategory = masterService.createSubCategory(postRequest);
		SubCategoryDTO postResponse = mapper.map(subCategory, SubCategoryDTO.class);

		return new ResponseEntity<SubCategoryDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createProduct" }, produces = "application/json")
	public ResponseEntity<ProductDTO> createProduct(@RequestBody @Valid ProductDTO productDTO) throws Exception {
		
		Product postRequest = mapper.map(productDTO, Product.class);
		Product product = masterService.createProduct(postRequest);
		ProductDTO postResponse = mapper.map(product, ProductDTO.class);

		return new ResponseEntity<ProductDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createCurrency" }, produces = "application/json")
	public ResponseEntity<CurrencyDTO> createCurrency(@RequestBody @Valid CurrencyDTO currencyDTO) throws Exception {
		
		Currency postRequest = mapper.map(currencyDTO, Currency.class);
		Currency currency = masterService.createCurrency(postRequest);
		CurrencyDTO postResponse = mapper.map(currency, CurrencyDTO.class);

		return new ResponseEntity<CurrencyDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createCountry" }, produces = "application/json")
	public ResponseEntity<CountryDTO> createCountry(@RequestBody @Valid CountryDTO countryDTO) throws Exception {
		
		Country postRequest = mapper.map(countryDTO, Country.class);
		Country country = masterService.createCountry(postRequest);
		CountryDTO postResponse = mapper.map(country, CountryDTO.class);

		return new ResponseEntity<CountryDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createState" }, produces = "application/json")
	public ResponseEntity<StateDTO> createState(@RequestBody @Valid StateDTO stateDTO) throws Exception {
		
		State postRequest = mapper.map(stateDTO, State.class);
		State state = masterService.createState(postRequest);
		StateDTO postResponse = mapper.map(state, StateDTO.class);

		return new ResponseEntity<StateDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createCity" }, produces = "application/json")
	public ResponseEntity<CityDTO> createCity(@RequestBody @Valid CityDTO cityDTO) throws Exception {
		
		City postRequest = mapper.map(cityDTO, City.class);
		City city = masterService.createCity(postRequest);
		CityDTO postResponse = mapper.map(city, CityDTO.class);

		return new ResponseEntity<CityDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createDepartment" }, produces = "application/json")
	public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody @Valid DepartmentDTO departmentDTO) throws Exception {
		
		Department postRequest = mapper.map(departmentDTO, Department.class);
		Department department = masterService.createDepartment(postRequest);
		DepartmentDTO postResponse = mapper.map(department, DepartmentDTO.class);

		return new ResponseEntity<DepartmentDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "cretateDeliveryTerms" }, produces = "application/json")
	public ResponseEntity<DeliveryTermsDTO> cretateDeliveryTerms(@RequestBody @Valid DeliveryTermsDTO deliveryTermsDTO) throws Exception {
		
		DeliveryTerms postRequest = mapper.map(deliveryTermsDTO, DeliveryTerms.class);
		DeliveryTerms deliveryTerms = masterService.cretateDeliveryTerms(postRequest);
		DeliveryTermsDTO postResponse = mapper.map(deliveryTerms, DeliveryTermsDTO.class);

		return new ResponseEntity<DeliveryTermsDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createUnit" }, produces = "application/json")
	public ResponseEntity<UnitDTO> createUnit(@RequestBody @Valid UnitDTO unitDTO) throws Exception {
		
		Unit postRequest = mapper.map(unitDTO, Unit.class);
		Unit unit = masterService.createUnit(postRequest);
		UnitDTO postResponse = mapper.map(unit, UnitDTO.class);

		return new ResponseEntity<UnitDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createTimeZone" }, produces = "application/json")
	public ResponseEntity<TimeZoneDTO> createTimeZone(@RequestBody @Valid TimeZoneDTO timeZoneDTO) throws Exception {
		
		TimeZone postRequest = mapper.map(timeZoneDTO, TimeZone.class);
		TimeZone timeZone = masterService.createTimeZone(postRequest);
		TimeZoneDTO postResponse = mapper.map(timeZone, TimeZoneDTO.class);

		return new ResponseEntity<TimeZoneDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createMarketStrategy" }, produces = "application/json")
	public ResponseEntity<MarketStrategyDTO> cretateMarketStrategy(@RequestBody @Valid MarketStrategyDTO marketStrategyDTO) throws Exception {
		
		MarketStrategy postRequest = mapper.map(marketStrategyDTO, MarketStrategy.class);
		MarketStrategy marketStrategy = masterService.cretateMarketStrategy(postRequest);
		MarketStrategyDTO postResponse = mapper.map(marketStrategy, MarketStrategyDTO.class);

		return new ResponseEntity<MarketStrategyDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createIndustryType" }, produces = "application/json")
	public ResponseEntity<IndustryTypeDTO> cretateIndustryType(@RequestBody @Valid IndustryTypeDTO industryTypeDTO) throws Exception {
		
		IndustryType postRequest = mapper.map(industryTypeDTO, IndustryType.class);
		IndustryType industryType = masterService.cretateIndustryType(postRequest);
		IndustryTypeDTO postResponse = mapper.map(industryType, IndustryTypeDTO.class);

		return new ResponseEntity<IndustryTypeDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createProductSpecification" }, produces = "application/json")
	public ResponseEntity<ProductSpecificationDTO> createProductSpecification(@RequestBody @Valid ProductSpecificationDTO productSpecificationDTO) throws Exception {
		
		ProductSpecification postRequest = mapper.map(productSpecificationDTO, ProductSpecification.class);
		ProductSpecification productSpecification = masterService.createProductSpecification(postRequest);
		ProductSpecificationDTO postResponse = mapper.map(productSpecification, ProductSpecificationDTO.class);

		return new ResponseEntity<ProductSpecificationDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createOrganizationType" }, produces = "application/json")
	public ResponseEntity<OrganizationTypeDTO> createOrganizationType(@RequestBody @Valid OrganizationTypeDTO organizationTypeDTO) throws Exception {
		
		OrganizationType postRequest = mapper.map(organizationTypeDTO, OrganizationType.class);
		OrganizationType organizationType = masterService.cretateIndustryType(postRequest);
		OrganizationTypeDTO postResponse = mapper.map(organizationType, OrganizationTypeDTO.class);

		return new ResponseEntity<OrganizationTypeDTO>(postResponse, HttpStatus.CREATED);
	}
	
	@PostMapping(value = { "createNatureOfBusinesse" }, produces = "application/json")
	public ResponseEntity<NatureOfBusinessDTO> cretateNatureOfBusiness(@RequestBody @Valid NatureOfBusinessDTO natureOfBusinessDTO) throws Exception {
		
		NatureOfBusiness postRequest = mapper.map(natureOfBusinessDTO, NatureOfBusiness.class);
		NatureOfBusiness natureOfBusiness = masterService.cretateNatureOfBusiness(postRequest);
		NatureOfBusinessDTO postResponse = mapper.map(natureOfBusiness, NatureOfBusinessDTO.class);

		return new ResponseEntity<NatureOfBusinessDTO>(postResponse, HttpStatus.CREATED);
	}
}
