package com.maxegg.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// 数据类型
public class Item implements Serializable{

	private static final long serialVersionUID = -332323412523252257L;

	private Object m_item = null;
	private Map<String, String> m_property = null;

	public void addProperty(String name, String val) {
		if (m_property == null) {
			m_property = new HashMap<String, String>();
		}
		m_property.put(name, val);
	}

	public String getProperty(String name) {
		if (m_property == null) {
			return "";
		}
		if (m_property.containsKey(name)) {
			return (String) m_property.get(name);
		}
		return "";
	}

	public Set<String> getProperty() {
		if (m_property == null) {
			return null;
		}
		return m_property.keySet();
	}

	public Item(Object item) {
		m_item = item;
	}

	public String getObjectStr() {
		return String.valueOf(m_item);
	}

	public boolean getBooleanColumn() {
		if (m_item instanceof Boolean) {
			return ((Boolean) m_item).booleanValue();
		}
		return false;
	}

	public String getStringColumn() {
		if (m_item instanceof String) {
			return (String) m_item;
		}
		return "";
	}

	public Date getDateColumn() {
		if (m_item instanceof Date) {
			return (Date) m_item;
		}
		return null;
	}

	public int getIntegerColumn() {
		if (m_item instanceof Integer) {
			return ((Integer) m_item).intValue();
		}
		if (m_item instanceof BigDecimal) {
			return ((BigDecimal) m_item).intValue();
		}
		return 0;
	}

	public long getLongColumn() {
		if (m_item instanceof Long) {
			return ((Long) m_item).longValue();
		}
		if (m_item instanceof BigDecimal) {
			return ((BigDecimal) m_item).longValue();
		}
		return 0;
	}

	public float getFloatColumn() {
		if (m_item instanceof Float) {
			return ((Float) m_item).floatValue();
		}
		if (m_item instanceof BigDecimal) {
			return ((BigDecimal) m_item).floatValue();
		}
		return 0;
	}

	public double getDoubleColumn() {
		if (m_item instanceof Double) {
			return ((Double) m_item).doubleValue();
		}
		if (m_item instanceof BigDecimal) {
			return ((BigDecimal) m_item).doubleValue();
		}
		return 0;
	}

	public BigDecimal getDecimalColumn() {
		if (m_item instanceof BigDecimal) {
			return ((BigDecimal) m_item);
		}
		return new BigDecimal(0);
	}

	public String toString() {
		return this.getStringColumn();
	}

	public boolean equals(Object item) {
		if (this.m_item == null) {
			return false;
		}
		if (item instanceof Item) {
			return this.m_item.equals(((Item) item).m_item);
		} else {
			return this.m_item.equals(item);
		}
	}
}
