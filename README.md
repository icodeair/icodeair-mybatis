欢迎使用！


/**
* 参考用
*
* @param <M> mapper类
* @param <T> 实体类对象
  */
  public class ICodeAirBaseServiceImpl<M extends BaseMapper<T>, T> extends AbstractBaseService<M, T> {
  @Override
  public Object getUserId() {
  return IdUtil.getSnowflakeNextId();
  }

  @Override
  public Object getId() {
  return IdUtil.getSnowflakeNextId();
  }
  }
