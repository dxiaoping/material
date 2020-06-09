package com.powersi.material.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EmployeeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmployeeExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNull() {
            addCriterion("emp_name is null");
            return (Criteria) this;
        }

        public Criteria andEmpNameIsNotNull() {
            addCriterion("emp_name is not null");
            return (Criteria) this;
        }

        public Criteria andEmpNameEqualTo(String value) {
            addCriterion("emp_name =", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotEqualTo(String value) {
            addCriterion("emp_name <>", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThan(String value) {
            addCriterion("emp_name >", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameGreaterThanOrEqualTo(String value) {
            addCriterion("emp_name >=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThan(String value) {
            addCriterion("emp_name <", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLessThanOrEqualTo(String value) {
            addCriterion("emp_name <=", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameLike(String value) {
            addCriterion("emp_name like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotLike(String value) {
            addCriterion("emp_name not like", value, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameIn(List<String> values) {
            addCriterion("emp_name in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotIn(List<String> values) {
            addCriterion("emp_name not in", values, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameBetween(String value1, String value2) {
            addCriterion("emp_name between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpNameNotBetween(String value1, String value2) {
            addCriterion("emp_name not between", value1, value2, "empName");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNull() {
            addCriterion("emp_sex is null");
            return (Criteria) this;
        }

        public Criteria andEmpSexIsNotNull() {
            addCriterion("emp_sex is not null");
            return (Criteria) this;
        }

        public Criteria andEmpSexEqualTo(String value) {
            addCriterion("emp_sex =", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotEqualTo(String value) {
            addCriterion("emp_sex <>", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThan(String value) {
            addCriterion("emp_sex >", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexGreaterThanOrEqualTo(String value) {
            addCriterion("emp_sex >=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThan(String value) {
            addCriterion("emp_sex <", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLessThanOrEqualTo(String value) {
            addCriterion("emp_sex <=", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexLike(String value) {
            addCriterion("emp_sex like", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotLike(String value) {
            addCriterion("emp_sex not like", value, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexIn(List<String> values) {
            addCriterion("emp_sex in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotIn(List<String> values) {
            addCriterion("emp_sex not in", values, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexBetween(String value1, String value2) {
            addCriterion("emp_sex between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpSexNotBetween(String value1, String value2) {
            addCriterion("emp_sex not between", value1, value2, "empSex");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIsNull() {
            addCriterion("emp_birthday is null");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIsNotNull() {
            addCriterion("emp_birthday is not null");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("emp_birthday =", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("emp_birthday <>", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("emp_birthday >", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("emp_birthday >=", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("emp_birthday <", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("emp_birthday <=", value, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("emp_birthday in", values, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("emp_birthday not in", values, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("emp_birthday between", value1, value2, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("emp_birthday not between", value1, value2, "empBirthday");
            return (Criteria) this;
        }

        public Criteria andEmpRoleIsNull() {
            addCriterion("emp_role is null");
            return (Criteria) this;
        }

        public Criteria andEmpRoleIsNotNull() {
            addCriterion("emp_role is not null");
            return (Criteria) this;
        }

        public Criteria andEmpRoleEqualTo(String value) {
            addCriterion("emp_role =", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleNotEqualTo(String value) {
            addCriterion("emp_role <>", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleGreaterThan(String value) {
            addCriterion("emp_role >", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleGreaterThanOrEqualTo(String value) {
            addCriterion("emp_role >=", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleLessThan(String value) {
            addCriterion("emp_role <", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleLessThanOrEqualTo(String value) {
            addCriterion("emp_role <=", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleLike(String value) {
            addCriterion("emp_role like", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleNotLike(String value) {
            addCriterion("emp_role not like", value, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleIn(List<String> values) {
            addCriterion("emp_role in", values, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleNotIn(List<String> values) {
            addCriterion("emp_role not in", values, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleBetween(String value1, String value2) {
            addCriterion("emp_role between", value1, value2, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpRoleNotBetween(String value1, String value2) {
            addCriterion("emp_role not between", value1, value2, "empRole");
            return (Criteria) this;
        }

        public Criteria andEmpTelpIsNull() {
            addCriterion("emp_telp is null");
            return (Criteria) this;
        }

        public Criteria andEmpTelpIsNotNull() {
            addCriterion("emp_telp is not null");
            return (Criteria) this;
        }

        public Criteria andEmpTelpEqualTo(String value) {
            addCriterion("emp_telp =", value, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpNotEqualTo(String value) {
            addCriterion("emp_telp <>", value, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpGreaterThan(String value) {
            addCriterion("emp_telp >", value, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpGreaterThanOrEqualTo(String value) {
            addCriterion("emp_telp >=", value, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpLessThan(String value) {
            addCriterion("emp_telp <", value, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpLessThanOrEqualTo(String value) {
            addCriterion("emp_telp <=", value, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpLike(String value) {
            addCriterion("emp_telp like", value, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpNotLike(String value) {
            addCriterion("emp_telp not like", value, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpIn(List<String> values) {
            addCriterion("emp_telp in", values, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpNotIn(List<String> values) {
            addCriterion("emp_telp not in", values, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpBetween(String value1, String value2) {
            addCriterion("emp_telp between", value1, value2, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpTelpNotBetween(String value1, String value2) {
            addCriterion("emp_telp not between", value1, value2, "empTelp");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateIsNull() {
            addCriterion("emp_join_date is null");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateIsNotNull() {
            addCriterion("emp_join_date is not null");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateEqualTo(Date value) {
            addCriterionForJDBCDate("emp_join_date =", value, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("emp_join_date <>", value, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateGreaterThan(Date value) {
            addCriterionForJDBCDate("emp_join_date >", value, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("emp_join_date >=", value, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateLessThan(Date value) {
            addCriterionForJDBCDate("emp_join_date <", value, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("emp_join_date <=", value, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateIn(List<Date> values) {
            addCriterionForJDBCDate("emp_join_date in", values, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("emp_join_date not in", values, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("emp_join_date between", value1, value2, "empJoinDate");
            return (Criteria) this;
        }

        public Criteria andEmpJoinDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("emp_join_date not between", value1, value2, "empJoinDate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}