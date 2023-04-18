package com.metis.nopaper.work.master.services;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.metis.nopaper.work.master.constant.MasterConstant;
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
import com.metis.nopaper.work.master.models.repositories.CategoryRepository;
import com.metis.nopaper.work.master.models.repositories.CityRepository;
import com.metis.nopaper.work.master.models.repositories.CountryRepository;
import com.metis.nopaper.work.master.models.repositories.CurrencyRepository;
import com.metis.nopaper.work.master.models.repositories.DeliveryTermsRepository;
import com.metis.nopaper.work.master.models.repositories.DepartmentRepository;
import com.metis.nopaper.work.master.models.repositories.IndustryTypeRepository;
import com.metis.nopaper.work.master.models.repositories.MarketStrategyRepository;
import com.metis.nopaper.work.master.models.repositories.NatureOfBusinessRepository;
import com.metis.nopaper.work.master.models.repositories.OrganizationTypeRepository;
import com.metis.nopaper.work.master.models.repositories.ProductRepository;
import com.metis.nopaper.work.master.models.repositories.ProductSpecificationRepository;
import com.metis.nopaper.work.master.models.repositories.StateRepository;
import com.metis.nopaper.work.master.models.repositories.SubCategoryRepository;
import com.metis.nopaper.work.master.models.repositories.TimeZoneRepository;
import com.metis.nopaper.work.master.models.repositories.UnitRepository;

@Service
@CacheConfig(cacheNames = "master")
public class MasterService implements IMasterService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MasterService.class);

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CurrencyRepository currencyRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private DeliveryTermsRepository deliveryTermsRepository;

	@Autowired
	private UnitRepository unitRepository;

	@Autowired
	private TimeZoneRepository timeZoneRepository;

	@Autowired
	private MarketStrategyRepository marketStrategyRepository;

	@Autowired
	private IndustryTypeRepository industryTypeRepository;

	@Autowired
	private NatureOfBusinessRepository natureOfBusinessRepository;

	@Autowired
	private OrganizationTypeRepository organizationTypeRepository;

	@Autowired
	private ProductSpecificationRepository productSpecificationRepository;

	@Cacheable(cacheNames = "Currency")
	@Override
	public List<Currency> getCurrencyList() {
		return currencyRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Unit")
	@Override
	public List<Unit> getUnitList() {
		return unitRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Category")
	@Override
	public List<Category> getCategoryList() {
		return categoryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Country")
	@Override
	public List<Country> getCountryList() {
		return countryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "State")
	@Override
	public List<State> getStateList() {
		return stateRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "City")
	@Override
	public List<City> getCityList() {
		return cityRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "SubCategory")
	@Override
	public List<SubCategory> getSubCategoryList() {
		return subCategoryRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Product")
	@Override
	public List<Product> getProduct() {
		return productRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Override
	public Currency getCurrencyById(UUID id) {
		return currencyRepository.findById(id).orElse(null);
	}

	@Override
	public Unit getUnitById(UUID id) {
		return unitRepository.findById(id).orElse(null);
	}

	@Override
	public Category getCategoryById(UUID id) {
		return categoryRepository.findById(id).orElse(null);
	}

	@Override
	public Country getCountryById(UUID id) {
		return countryRepository.findById(id).orElse(null);
	}

	@Override
	public State getStateById(UUID id) {
		return stateRepository.findById(id).orElse(null);
	}

	@Override
	public City getCityById(UUID id) {
		return cityRepository.findById(id).orElse(null);
	}

	@Override
	public SubCategory getSubCategoryById(UUID id) {
		return subCategoryRepository.findById(id).orElse(null);
	}

	@Override
	public Product getProductById(UUID id) {
		return productRepository.findById(id).orElse(null);
	}

	@Cacheable(cacheNames = "State")
	@Override
	public List<State> getStateListByCountryId(UUID id, String status) {
		return stateRepository.getStateListByCountryId(id, status);
	}

	@Cacheable(cacheNames = "City")
	@Override
	public List<City> getCityListByStateId(UUID id, String status) {
		return cityRepository.getCityListByStateId(id, status);
	}

	@Cacheable(cacheNames = "Product")
	@Override
	public List<Product> getProductBySubCategoryId(UUID id, String status) {
		return productRepository.getProductBySubCategoryId(id, status);
	}

	@Cacheable(cacheNames = "SubCategory")
	@Override
	public List<SubCategory> getSubCategoryByCategoryId(UUID id, String status) {
		return subCategoryRepository.getSubCategoryByCategoryId(id, status);
	}

	@Override
	public Category createCategory(Category postRequest) {
		return categoryRepository.saveAndFlush(postRequest);
	}

	@Override
	public SubCategory createSubCategory(SubCategory postRequest) {
		return subCategoryRepository.saveAndFlush(postRequest);
	}

	@Override
	public Product createProduct(Product postRequest) {
		return productRepository.saveAndFlush(postRequest);
	}

	public Currency createCurrency(Currency postRequest) {
		return currencyRepository.saveAndFlush(postRequest);
	}

	@Override
	public State createState(State postRequest) {
		return stateRepository.saveAndFlush(postRequest);
	}

	@Override
	public Country createCountry(Country postRequest) {
		return countryRepository.saveAndFlush(postRequest);
	}

	@Override
	public City createCity(City postRequest) {
		return cityRepository.saveAndFlush(postRequest);
	}

	@Override
	public Department createDepartment(Department postRequest) {
		return departmentRepository.saveAndFlush(postRequest);
	}

	@Override
	public DeliveryTerms cretateDeliveryTerms(DeliveryTerms postRequest) {
		return deliveryTermsRepository.saveAndFlush(postRequest);
	}

	@Override
	public Unit createUnit(Unit postRequest) {
		return unitRepository.saveAndFlush(postRequest);
	}

	@Override
	public TimeZone createTimeZone(TimeZone postRequest) {
		return timeZoneRepository.saveAndFlush(postRequest);
	}

	@Override
	public MarketStrategy cretateMarketStrategy(MarketStrategy postRequest) {
		return marketStrategyRepository.saveAndFlush(postRequest);
	}

	@Override
	public IndustryType cretateIndustryType(IndustryType postRequest) {
		return industryTypeRepository.saveAndFlush(postRequest);
	}

	@Override
	public ProductSpecification createProductSpecification(ProductSpecification postRequest) {
		return productSpecificationRepository.saveAndFlush(postRequest);
	}

	@Override
	public OrganizationType cretateIndustryType(OrganizationType postRequest) {
		return organizationTypeRepository.saveAndFlush(postRequest);
	}

	@Override
	public NatureOfBusiness cretateNatureOfBusiness(NatureOfBusiness postRequest) {
		return natureOfBusinessRepository.saveAndFlush(postRequest);
	}

	@Override
	public Department getDepartmentById(UUID id) {
		return departmentRepository.findById(id).orElse(null);
	}

	@Override
	public DeliveryTerms getDeliveryTermsById(UUID id) {
		return deliveryTermsRepository.findById(id).orElse(null);
	}

	@Cacheable(cacheNames = "DeliveryTerms")
	@Override
	public List<DeliveryTerms> getDeliveryTermsList() {
		return deliveryTermsRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "Department")
	@Override
	public List<Department> getDepartmentList() {
		return departmentRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Override
	public IndustryType getIndustryTypeById(UUID id) {
		return industryTypeRepository.findById(id).orElse(null);
	}

	@Cacheable(cacheNames = "IndustryType")
	@Override
	public List<IndustryType> getIndustryTypeList() {
		return industryTypeRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Override
	public MarketStrategy getMarketStrategyById(UUID id) {
		return marketStrategyRepository.findById(id).orElse(null);
	}

	@Cacheable(cacheNames = "MarketStrategy")
	@Override
	public List<MarketStrategy> getMarketStrategyList() {
		return marketStrategyRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Override
	public NatureOfBusiness getNatureOfBusinessById(UUID id) {
		return natureOfBusinessRepository.findById(id).orElse(null);
	}

	@Cacheable(cacheNames = "NatureOfBusiness")
	@Override
	public List<NatureOfBusiness> getNatureOfBusinessList() {
		return natureOfBusinessRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Override
	public OrganizationType getOrganizationTypeById(UUID id) {
		return organizationTypeRepository.findById(id).orElse(null);
	}

	@Cacheable(cacheNames = "OrganizationType")
	@Override
	public List<OrganizationType> getOrganizationTypeList() {
		return organizationTypeRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Cacheable(cacheNames = "ProductSpecification")
	@Override
	public List<ProductSpecification> getProductSpecificationList() {
		return productSpecificationRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Override
	public TimeZone getTimeZoneById(UUID id) {
		return timeZoneRepository.findById(id).orElse(null);
	}

	@Cacheable(cacheNames = "TimeZone")
	@Override
	public List<TimeZone> getTimeZoneList() {
		return timeZoneRepository.findByStatus(MasterConstant.DEFAULT_STATUS);
	}

	@Override
	public ProductSpecification getProductSpecificationById(UUID id) {
		return productSpecificationRepository.findById(id).orElse(null);
	}

}
