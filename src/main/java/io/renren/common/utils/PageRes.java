package io.renren.common.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PageRes<T> implements IPage<T> {

  private List<T> records;
  private long total;
  private long size;
  private long current;

  @Override
  public List<OrderItem> orders() {
    return null;
  }

  @Override
  public List<T> getRecords() {
    return this.records;
  }

  @Override
  public IPage<T> setRecords(List<T> records) {
    this.records = records;
    return this;
  }

  @Override
  public long getTotal() {
    return this.total;
  }

  @Override
  public IPage<T> setTotal(long total) {
    this.total = total;
    return this;
  }

  @Override
  public long getSize() {
    return this.size;
  }

  @Override
  public IPage<T> setSize(long size) {
    this.size = size;
    return this;
  }

  @Override
  public long getCurrent() {
    return this.current;
  }

  @Override
  public IPage<T> setCurrent(long current) {
    this.current = current;
    return this;
  }
}
