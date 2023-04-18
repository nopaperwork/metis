package com.metis.nopaper.work.master.services;

import java.util.List;
import java.util.UUID;

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

public interface IMasterService {

	Currency getCurrencyById(UUID id);

	Unit getUnitById(UUID id);

	Category getCategoryById(UUID id);

	SubCategory getSubCategoryById(UUID id);

	Product getProductById(UUID id);

	Country getCountryById(UUID id);

	State getStateById(UUID id);

	City getCityById(UUID id);

	/*
	 * All list of Masters
	 */

	List<Currency> getCurrencyList();

	List<Unit> getUnitList();

	List<Category> getCategoryList();

	List<SubCategory> getSubCategoryList();

	List<Product> getProduct();

	List<Country> getCountryList();

	List<State> getStateList();

	List<City> getCityList();

	/*
	 * Conditional Joins with Parent ID
	 */

	List<SubCategory> getSubCategoryByCategoryId(UUID id, String status);

	List<Product> getProductBySubCategoryId(UUID id, String status);

	List<State> getStateListByCountryId(UUID id, String status);

	List<City> getCityListByStateId(UUID id, String status);

	/*
	 * MASTER CREATE OPTIONS
	 */

	Category createCategory(Category postRequest);

	SubCategory createSubCategory(SubCategory postRequest);

	Product createProduct(Product postRequest);

	Currency createCurrency(Currency postRequest);

	State createState(State postRequest);

	Country createCountry(Country postRequest);

	City createCity(City postRequest);

	Department createDepartment(Department postRequest);

	DeliveryTerms cretateDeliveryTerms(DeliveryTerms postRequest);

	Unit createUnit(Unit postRequest);

	TimeZone createTimeZone(TimeZone postRequest);

	MarketStrategy cretateMarketStrategy(MarketStrategy postRequest);

	IndustryType cretateIndustryType(IndustryType postRequest);

	ProductSpecification createProductSpecification(ProductSpecification postRequest);

	OrganizationType cretateIndustryType(OrganizationType postRequest);

	NatureOfBusiness cretateNatureOfBusiness(NatureOfBusiness postRequest);
	
	/*
	 * Others
	 */

	Department getDepartmentById(UUID id);

	DeliveryTerms getDeliveryTermsById(UUID id);

	List<DeliveryTerms> getDeliveryTermsList();

	List<Department> getDepartmentList();

	IndustryType getIndustryTypeById(UUID id);

	List<IndustryType> getIndustryTypeList();

	MarketStrategy getMarketStrategyById(UUID id);

	List<MarketStrategy> getMarketStrategyList();

	NatureOfBusiness getNatureOfBusinessById(UUID id);

	List<NatureOfBusiness> getNatureOfBusinessList();

	OrganizationType getOrganizationTypeById(UUID id);

	List<OrganizationType> getOrganizationTypeList();

	List<ProductSpecification> getProductSpecificationList();

	TimeZone getTimeZoneById(UUID id);

	List<TimeZone> getTimeZoneList();

	ProductSpecification getProductSpecificationById(UUID id);

}
