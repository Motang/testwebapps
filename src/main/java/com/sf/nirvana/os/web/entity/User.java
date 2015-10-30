package com.sf.nirvana.os.web.entity;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = -3563486840099068083L;

	private String email;
	private String mobile;
	private String nickName;
	private String realName;
	private String birthday;
	private int degree;
	private int income;
	private String cards;
	private int country;
	private int province;
	private int city;
	private int district;
	private boolean payPassValid;
	private int userType;

	private int userId;
	private boolean emailValid;
	private boolean mobileValid;
	private int userSex;
	private int userRank;
	private String rankName;
	private double balanceYuan;
	private double frozenMoneyYuan;
	private int payPoints;
	private int frozenPoint;
	private int loginCount;
	private String userName;
	private double fundTotalYuan;
	private double fundLastDonation;
	private double fundAllDonation;
	private double fundBalance;
	private String headPic;
	private int userState;
	private boolean isBlack;
	private int mobileValidTime;
	private int from;
	private int emailValidTime;
	private int partnerId;
	private int rankChangeTime;
	private String cpaParams;
	private int regTime;
	private String regIp;
	private int userSource;
	private String userPwd;
	private String smsCode;
	private String dmCode;
	private String payPass;
	private boolean userSafe;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public String getCards() {
		return cards;
	}

	public void setCards(String cards) {
		this.cards = cards;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getDistrict() {
		return district;
	}

	public void setDistrict(int district) {
		this.district = district;
	}

	public boolean isPayPassValid() {
		return payPassValid;
	}

	public void setPayPassValid(boolean payPassValid) {
		this.payPassValid = payPassValid;
	}

	public int getUserType() {
		return userType;
	}

	public String getPayPass() {
		return payPass;
	}

	public void setPayPass(String payPass) {
		this.payPass = payPass;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isEmailValid() {
		return emailValid;
	}

	public void setEmailValid(boolean emailValid) {
		this.emailValid = emailValid;
	}

	public boolean isMobileValid() {
		return mobileValid;
	}

	public void setMobileValid(boolean mobileValid) {
		this.mobileValid = mobileValid;
	}

	public int getUserSex() {
		return userSex;
	}

	public void setUserSex(int userSex) {
		this.userSex = userSex;
	}

	public int getUserRank() {
		return userRank;
	}

	public void setUserRank(int userRank) {
		this.userRank = userRank;
	}

	public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public double getBalanceYuan() {
		return balanceYuan;
	}

	public void setBalanceYuan(double balanceYuan) {
		this.balanceYuan = balanceYuan;
	}

	public double getFrozenMoneyYuan() {
		return frozenMoneyYuan;
	}

	public void setFrozenMoneyYuan(double frozenMoneyYuan) {
		this.frozenMoneyYuan = frozenMoneyYuan;
	}

	public int getPayPoints() {
		return payPoints;
	}

	public void setPayPoints(int payPoints) {
		this.payPoints = payPoints;
	}

	public int getFrozenPoint() {
		return frozenPoint;
	}

	public void setFrozenPoint(int frozenPoint) {
		this.frozenPoint = frozenPoint;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public double getFundTotalYuan() {
		return fundTotalYuan;
	}

	public void setFundTotalYuan(double fundTotalYuan) {
		this.fundTotalYuan = fundTotalYuan;
	}

	public double getFundLastDonation() {
		return fundLastDonation;
	}

	public void setFundLastDonation(double fundLastDonation) {
		this.fundLastDonation = fundLastDonation;
	}

	public double getFundAllDonation() {
		return fundAllDonation;
	}

	public void setFundAllDonation(double fundAllDonation) {
		this.fundAllDonation = fundAllDonation;
	}

	public double getFundBalance() {
		return fundBalance;
	}

	public void setFundBalance(double fundBalance) {
		this.fundBalance = fundBalance;
	}

	public String getHeadPic() {
		return headPic;
	}

	public void setHeadPic(String headPic) {
		this.headPic = headPic;
	}

	public int getUserState() {
		return userState;
	}

	public void setUserState(int userState) {
		this.userState = userState;
	}

	public boolean isBlack() {
		return isBlack;
	}

	public void setBlack(boolean isBlack) {
		this.isBlack = isBlack;
	}

	public int getMobileValidTime() {
		return mobileValidTime;
	}

	public void setMobileValidTime(int mobileValidTime) {
		this.mobileValidTime = mobileValidTime;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) {
		this.from = from;
	}

	public int getEmailValidTime() {
		return emailValidTime;
	}

	public void setEmailValidTime(int emailValidTime) {
		this.emailValidTime = emailValidTime;
	}

	public int getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(int partnerId) {
		this.partnerId = partnerId;
	}

	public int getRankChangeTime() {
		return rankChangeTime;
	}

	public void setRankChangeTime(int rankChangeTime) {
		this.rankChangeTime = rankChangeTime;
	}

	public String getCpaParams() {
		return cpaParams;
	}

	public void setCpaParams(String cpaParams) {
		this.cpaParams = cpaParams;
	}

	public int getRegTime() {
		return regTime;
	}

	public void setRegTime(int regTime) {
		this.regTime = regTime;
	}

	public String getRegIp() {
		return regIp;
	}

	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}

	public int getUserSource() {
		return userSource;
	}

	public void setUserSource(int userSource) {
		this.userSource = userSource;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getSmsCode() {
		return smsCode;
	}

	public void setSmsCode(String smsCode) {
		this.smsCode = smsCode;
	}

	public String getDmCode() {
		return dmCode;
	}

	public void setDmCode(String dmCode) {
		this.dmCode = dmCode;
	}

	public boolean isUserSafe() {
		return userSafe;
	}

	public void setUserSafe(boolean userSafe) {
		this.userSafe = userSafe;
	}

}
