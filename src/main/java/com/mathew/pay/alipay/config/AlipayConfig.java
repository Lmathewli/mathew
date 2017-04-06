package com.mathew.pay.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2017040606569185";
	// 商户的私钥
	public static String private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDFsJT0NTP/6g0FhDalX7ryQXdSOd3OvtVOFeNm+hiOJGqvFeAe3Dm/hXelSiTmdPeLpCoo7ugbdPF5Q258db3a9ldszjVq+wt/z7wFygbR3ooznzgxI/PwoQN660lxtzix9nlmjzu+oV8FdE3P7Ivptf7SvO8F/3qe24Ir9iuzhNcjwOTsF+rsNPDOigYja5KwPPTnMqhpclNLQQUklo6mFQVYnRKfNIxvSCBMyM40X63OqG3tLoD1uoz7mqug35NV2aoCUau97YO8PmRu7w22N6Lc1ervaV3Urv3+34aHe3lpPPGxyHHo0eXu0ZvMsNHhs8MqRG+BDWtteaKm2y+3AgMBAAECggEBAMK8lZ6SoiygND+Q4/u394IYdx/qnNLCLYEEEsQn7PRobycV13bO3ZwKL7gE96CE7C0Eg/tajA4v/obDpBy6J1GAhNJLt1cxATzgN4lEX79xBpafa00M64nIMpNtHyYDpLe54hDjW6kHcYD/9n6xt4l7nA+fyZ0Q84t1FB+WGap1nNGJ9fYela3qIAouBeaV1hHUDBNLiYGAlbff9k+nw45AfADNg6eK5uuhwmXJJZFUtHIueB3pK26dbsxPS6MsP74XpZSDMhaiLvMaDPsre2c3GYOIhhyiPuPPFzMoTc9FO7BOLUj5qy6BAkfqyw/PeOTKbyvjHchKpu8QCopoFiECgYEA/XcuK7v06/TD1YKCxsxHMc7Mk3n9mp9Yp8MbSp6vojB68gb3OvrLyLN6P59K/1JMelg8zCcfGsKVC+XKGw+U9r5wl6OZSmfe7gJrpXoDwbR8VTaSYiEuUF8S/53O9bmq4voOhi1/p1okFCQ51SCS5thpJY5ag9TsNgsSaJbHm/8CgYEAx6qgglqSkWhk0GGFSspGfIdmSPRf0mAUjMAXxwoZ4/UbJCKamj7MBHJ/I9iMwqbev0u9quB09NZH3O72CcflVMCfHy+FSYtV2mjut7wbzLrLzfXRazP7atRBmAPAlEN0+XwLs0lQjg9jVnaDfjSrDYK7Odp+tm9Wh93LphpgTEkCgYEAjSsUzwznM4fmjoMa/UgHGwmXzUezZKv9P6qeB6hsH8QqpaQVjIbkewrjOo4owh1/NODyM65SV6AqTS8Vqo66I9cbdImMtfE2K4+zjr1vXDJ+0SMM0pSya9cYCMBG5XscX0BwWHD82SOOVp16jGaRCvtbTKyFY0lyqgLupMvdrtcCgYAoA6vzM8+X0IITuNeLq4oAvuniyQbDFHpJ0t1xCDc0FhUAYub07ozYf1G3j1h2Uhbl43n5Ws5VmvP/9Ovd/e+Z0piRGWbu3Duyb8EXlV1E5FKfzhnQEDTcrfkPTAE2NWal8RQvNAwuzCquU0X67vcw1/hJmd43FY0T4YFEopiV8QKBgA19QfpPG5F4psQrBfiHVvxuouw3t4hLzb6mwhwgZBmALqXYqAVmSCi2AIPmWR1nqhPLUY72hfjfMzXVYMp7oE64ZJTj4PpatPkdewRTdtxCzbLr8V0kkVzI+8BPoDu31ZFtYkjQp4ZupIE6a7BmdqoDi1S+EmPlblZPMVLBNUln";
	
	// 支付宝的公钥，无需修改该值
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
	
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//异步通知页面，就是接受支付宝支付结果返回信息的Controller，可以处理自己的支付后的逻辑
    //测试环境
    public static String notify_url = "http://192.168.0.106/mathew/payback";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    //同步跳转的页面，就是支付宝支付成功后页面跳转的url
    public static String return_url = "success";

    // 签名方式
    public static String sign_type = "MD5";

    // 调试用，创建TXT日志文件夹路径，见AlipayCore.java类中的logResult(String sWord)打印方法。
    public static String log_path = "C:\\";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = "utf-8";

    // 支付类型 ，无需修改
    public static String payment_type = "1";

    // 调用的接口名，无需修改
    public static String service = "create_direct_pay_by_user";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

//↓↓↓↓↓↓↓↓↓↓ 请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 防钓鱼时间戳  若要使用请调用类文件submit中的query_timestamp函数
    public static String anti_phishing_key = "";

    // 客户端的IP地址 非局域网的外网IP地址，如：221.0.0.1
    public static String exter_invoke_ip = "";
    public static String seller_id = "seller_id";

//↑↑↑↑↑↑↑↑↑↑请在这里配置防钓鱼信息，如果没开通防钓鱼功能，为空即可 ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑
}
