package com.sf.nirvana.os.web.utils;

public class OfConst {

	public static final String ORDER_GEN_SUCCESS_SN = "10330000";
	public static final String ORDER_GEN_SUCCESS = "订单提交成功";

	public static final String ORDER_GEN_ERROR_SN = "10330001";
	public static final String ORDER_GEN_ERROR = "订单提交失败";

	public static final String ORDER_SETTLEMENT_ERROR_SN = "10330002";
	public static final String ORDER_SETTLEMENT_ERROR = "抱歉，商品缺货或无法送达";

	public static final String ORDER_SETTLEMENT_CHANGE_ERROR_SN = "10330003";
	public static final String ORDER_SETTLEMENT_CHANGE_ERROR = "不支持的修改";

	public static final String ORDER_LACK_SUCCESS_SN = "10330004";
	public static final String ORDER_LACK_SUCCESS = "买赠或满赠活动赠品库存不足, 是否继续下单";

	public static final String ORDER_LIMIT_SUCCESS_SN = "10330005";
	public static final String ORDER_LIMIT_SUCCESS = "买赠活动赠品超出限制, 是否继续下单";

	public static final String OP_SUCCESS_SN = "10330006";
	public static final String OP_SUCCESS = "操作成功";

	public static final String OP_FAILED_SN = "10330007";
	public static final String OP_FAILED = "操作失败";

	public static final String OP_ADD_CART_FAILED_SN = "10330008";
	public static final String OP_ADD_CART_FAILED = "加入购物车失败";
	
	//页面token失效
	public static final String OP_GEN_TOKEN_EXPIRED_SN = "10330009";
	public static final String OP_GEN_TOKEN_EXPIRED = "页面超时请重新进行结算提单";
	
	//返回code=10201030,说明是“买赠或满赠活动赠品库存不足, 是否继续下单”
	//返回code=10201029,说明是“买赠活动赠品超出限制, 是否继续下单”
	public static final String USER_ORDER_REFRESH_TOKEN = "_order_creater_token";

	public static final String JIA_JIA_GOU_CODE = "10016";

	public static final String USER_NO_LOGIN_CART = "_user_no_login_cart";

	public static final String CART_PACKAGE = "T10001";
	public static final String CART_NM = "T10002";
	public static final String CART_JIAJIAGOU = "10016";
	
	public enum MobileSMSType { //0为找回密码 1为注册 2为绑定 3为修改
		SMS_FINDPWD(0), SMS_REGISTER(1), SMS_BIND(2), SMS_UPDATEPWD(3);
		
		private MobileSMSType(int num) {
			this.num = num;
		}
		
		private int num;

		public int getNum() {
			return num;
		}
		
	}

}
