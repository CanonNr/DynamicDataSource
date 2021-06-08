package com.example.dds.config;

public class DataSourceType {
    public enum DataBaseType {
        MASTER, SLAVE
    }

    // 使用ThreadLocal保证线程安全
    private static final ThreadLocal<DataBaseType> TYPE = new ThreadLocal<DataBaseType>();

    // 往当前线程里设置数据源类型
    public static void setDataBaseType(DataBaseType dataBaseType) {
        if (dataBaseType == null) {
            throw new NullPointerException();
        }
        TYPE.set(dataBaseType);
    }

    // 获取数据源类型
    public static DataBaseType getDataBaseType() {
        return TYPE.get() == null ? DataBaseType.MASTER : TYPE.get();
    }

    // 清空数据类型
    public static void clearDataBaseType() {
        TYPE.remove();
    }
}
