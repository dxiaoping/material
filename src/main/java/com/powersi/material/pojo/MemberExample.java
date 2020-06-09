package com.powersi.material.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MemberExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MemberExample() {
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

        public Criteria andMemberTelpIsNull() {
            addCriterion("member_telp is null");
            return (Criteria) this;
        }

        public Criteria andMemberTelpIsNotNull() {
            addCriterion("member_telp is not null");
            return (Criteria) this;
        }

        public Criteria andMemberTelpEqualTo(String value) {
            addCriterion("member_telp =", value, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpNotEqualTo(String value) {
            addCriterion("member_telp <>", value, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpGreaterThan(String value) {
            addCriterion("member_telp >", value, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpGreaterThanOrEqualTo(String value) {
            addCriterion("member_telp >=", value, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpLessThan(String value) {
            addCriterion("member_telp <", value, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpLessThanOrEqualTo(String value) {
            addCriterion("member_telp <=", value, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpLike(String value) {
            addCriterion("member_telp like", value, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpNotLike(String value) {
            addCriterion("member_telp not like", value, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpIn(List<String> values) {
            addCriterion("member_telp in", values, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpNotIn(List<String> values) {
            addCriterion("member_telp not in", values, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpBetween(String value1, String value2) {
            addCriterion("member_telp between", value1, value2, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberTelpNotBetween(String value1, String value2) {
            addCriterion("member_telp not between", value1, value2, "memberTelp");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdIsNull() {
            addCriterion("member_class_id is null");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdIsNotNull() {
            addCriterion("member_class_id is not null");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdEqualTo(String value) {
            addCriterion("member_class_id =", value, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdNotEqualTo(String value) {
            addCriterion("member_class_id <>", value, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdGreaterThan(String value) {
            addCriterion("member_class_id >", value, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdGreaterThanOrEqualTo(String value) {
            addCriterion("member_class_id >=", value, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdLessThan(String value) {
            addCriterion("member_class_id <", value, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdLessThanOrEqualTo(String value) {
            addCriterion("member_class_id <=", value, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdLike(String value) {
            addCriterion("member_class_id like", value, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdNotLike(String value) {
            addCriterion("member_class_id not like", value, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdIn(List<String> values) {
            addCriterion("member_class_id in", values, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdNotIn(List<String> values) {
            addCriterion("member_class_id not in", values, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdBetween(String value1, String value2) {
            addCriterion("member_class_id between", value1, value2, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberClassIdNotBetween(String value1, String value2) {
            addCriterion("member_class_id not between", value1, value2, "memberClassId");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNull() {
            addCriterion("member_name is null");
            return (Criteria) this;
        }

        public Criteria andMemberNameIsNotNull() {
            addCriterion("member_name is not null");
            return (Criteria) this;
        }

        public Criteria andMemberNameEqualTo(String value) {
            addCriterion("member_name =", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotEqualTo(String value) {
            addCriterion("member_name <>", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThan(String value) {
            addCriterion("member_name >", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameGreaterThanOrEqualTo(String value) {
            addCriterion("member_name >=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThan(String value) {
            addCriterion("member_name <", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLessThanOrEqualTo(String value) {
            addCriterion("member_name <=", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameLike(String value) {
            addCriterion("member_name like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotLike(String value) {
            addCriterion("member_name not like", value, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameIn(List<String> values) {
            addCriterion("member_name in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotIn(List<String> values) {
            addCriterion("member_name not in", values, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameBetween(String value1, String value2) {
            addCriterion("member_name between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberNameNotBetween(String value1, String value2) {
            addCriterion("member_name not between", value1, value2, "memberName");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumIsNull() {
            addCriterion("member_id_num is null");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumIsNotNull() {
            addCriterion("member_id_num is not null");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumEqualTo(String value) {
            addCriterion("member_id_num =", value, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumNotEqualTo(String value) {
            addCriterion("member_id_num <>", value, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumGreaterThan(String value) {
            addCriterion("member_id_num >", value, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumGreaterThanOrEqualTo(String value) {
            addCriterion("member_id_num >=", value, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumLessThan(String value) {
            addCriterion("member_id_num <", value, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumLessThanOrEqualTo(String value) {
            addCriterion("member_id_num <=", value, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumLike(String value) {
            addCriterion("member_id_num like", value, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumNotLike(String value) {
            addCriterion("member_id_num not like", value, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumIn(List<String> values) {
            addCriterion("member_id_num in", values, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumNotIn(List<String> values) {
            addCriterion("member_id_num not in", values, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumBetween(String value1, String value2) {
            addCriterion("member_id_num between", value1, value2, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberIdNumNotBetween(String value1, String value2) {
            addCriterion("member_id_num not between", value1, value2, "memberIdNum");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeIsNull() {
            addCriterion("member_reg_time is null");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeIsNotNull() {
            addCriterion("member_reg_time is not null");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeEqualTo(Date value) {
            addCriterionForJDBCDate("member_reg_time =", value, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("member_reg_time <>", value, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("member_reg_time >", value, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("member_reg_time >=", value, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeLessThan(Date value) {
            addCriterionForJDBCDate("member_reg_time <", value, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("member_reg_time <=", value, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeIn(List<Date> values) {
            addCriterionForJDBCDate("member_reg_time in", values, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("member_reg_time not in", values, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("member_reg_time between", value1, value2, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberRegTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("member_reg_time not between", value1, value2, "memberRegTime");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyIsNull() {
            addCriterion("member_amount_money is null");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyIsNotNull() {
            addCriterion("member_amount_money is not null");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyEqualTo(BigDecimal value) {
            addCriterion("member_amount_money =", value, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyNotEqualTo(BigDecimal value) {
            addCriterion("member_amount_money <>", value, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyGreaterThan(BigDecimal value) {
            addCriterion("member_amount_money >", value, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("member_amount_money >=", value, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyLessThan(BigDecimal value) {
            addCriterion("member_amount_money <", value, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyLessThanOrEqualTo(BigDecimal value) {
            addCriterion("member_amount_money <=", value, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyIn(List<BigDecimal> values) {
            addCriterion("member_amount_money in", values, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyNotIn(List<BigDecimal> values) {
            addCriterion("member_amount_money not in", values, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_amount_money between", value1, value2, "memberAmountMoney");
            return (Criteria) this;
        }

        public Criteria andMemberAmountMoneyNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("member_amount_money not between", value1, value2, "memberAmountMoney");
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