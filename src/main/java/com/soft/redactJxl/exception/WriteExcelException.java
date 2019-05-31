package com.soft.redactJxl.exception;
/**
 * 测试类
 * @ClassName:  WriteExcelException     
 * @author: tao wang
 * @date:   2018年11月16日   
 *
 */
public class WriteExcelException  extends RuntimeException {

	/**  
	 * @author: tao wang  
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */ 
	private static final long serialVersionUID = 2951287699254501531L;

	 //默认错误码
    private Integer errCode;
    private String message;


    
    public WriteExcelException() {
		super();
	}
    

	/**
     * 自定义状态码和msg
     *
     * @param errCode
     * @param message 注意格式
     */
    public WriteExcelException(Integer errCode, String message){
        this.message = message;
        this.errCode = errCode;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
	
	
}
