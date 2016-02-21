package module.tree.entity;

import java.math.BigDecimal;

/**
 * SsfFaLocation entity. @author MyEclipse Persistence Tools
 */

public class SsfFaLocation implements java.io.Serializable {

	// Fields

	private BigDecimal id;
	private BigDecimal pid;
	private String locPath;
	private BigDecimal locLevel;
	private String name;
	private String nameEn;
	private String namePinyin;
	private String code;
	private String currency;
	private BigDecimal roomPrice;
	private BigDecimal mealsPrice;
	private BigDecimal publicFeesPrice;
	private String favorite;

	// Constructors

	/** default constructor */
	public SsfFaLocation() {
	}

	/** minimal constructor */
	public SsfFaLocation(BigDecimal id) {
		this.id = id;
	}

	/** full constructor */
	public SsfFaLocation(BigDecimal id, BigDecimal pid, String locPath,
			BigDecimal locLevel, String name, String nameEn, String namePinyin,
			String code, String currency, BigDecimal roomPrice,
			BigDecimal mealsPrice, BigDecimal publicFeesPrice, String favorite) {
		this.id = id;
		this.pid = pid;
		this.locPath = locPath;
		this.locLevel = locLevel;
		this.name = name;
		this.nameEn = nameEn;
		this.namePinyin = namePinyin;
		this.code = code;
		this.currency = currency;
		this.roomPrice = roomPrice;
		this.mealsPrice = mealsPrice;
		this.publicFeesPrice = publicFeesPrice;
		this.favorite = favorite;
	}

	// Property accessors

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getPid() {
		return this.pid;
	}

	public void setPid(BigDecimal pid) {
		this.pid = pid;
	}

	public String getLocPath() {
		return this.locPath;
	}

	public void setLocPath(String locPath) {
		this.locPath = locPath;
	}

	public BigDecimal getLocLevel() {
		return this.locLevel;
	}

	public void setLocLevel(BigDecimal locLevel) {
		this.locLevel = locLevel;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	public String getNamePinyin() {
		return this.namePinyin;
	}

	public void setNamePinyin(String namePinyin) {
		this.namePinyin = namePinyin;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public BigDecimal getRoomPrice() {
		return this.roomPrice;
	}

	public void setRoomPrice(BigDecimal roomPrice) {
		this.roomPrice = roomPrice;
	}

	public BigDecimal getMealsPrice() {
		return this.mealsPrice;
	}

	public void setMealsPrice(BigDecimal mealsPrice) {
		this.mealsPrice = mealsPrice;
	}

	public BigDecimal getPublicFeesPrice() {
		return this.publicFeesPrice;
	}

	public void setPublicFeesPrice(BigDecimal publicFeesPrice) {
		this.publicFeesPrice = publicFeesPrice;
	}

	public String getFavorite() {
		return this.favorite;
	}

	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}

}