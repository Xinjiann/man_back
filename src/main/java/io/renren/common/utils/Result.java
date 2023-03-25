package io.renren.common.utils;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

  private int code;
  private String msg;
  private Object data;

  public static Result success() {
    return success(200, "操作成功", null);
  }

  public static Result success(Object data) {
    return success(200, "操作成功", data);
  }

  public static Result success(int code, String msg, Object data) {
    Result r = new Result();
    r.setCode(code);
    r.setData(data);
    r.setMsg(msg);
    return r;
  }

  public static Result fail() {
    return fail(400, null, null);
  }

  public static Result fail(String msg) {
    return fail(400, msg, null);
  }

  public static Result fail(String msg, Object data) {
    return fail(400, msg, data);
  }

  public static Result fail(int code, String msg, Object data) {
    Result r = new Result();
    r.setCode(code);
    r.setMsg(msg);
    r.setData(data);
    return r;
  }


}
