package com.powersi.material.pojo;

import java.util.ArrayList;
import java.util.List;

public class ItemClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemClassExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherIsNull() {
            addCriterion("item_class_father is null");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherIsNotNull() {
            addCriterion("item_class_father is not null");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherEqualTo(Integer value) {
            addCriterion("item_class_father =", value, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherNotEqualTo(Integer value) {
            addCriterion("item_class_father <>", value, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherGreaterThan(Integer value) {
            addCriterion("item_class_father >", value, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_class_father >=", value, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherLessThan(Integer value) {
            addCriterion("item_class_father <", value, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherLessThanOrEqualTo(Integer value) {
            addCriterion("item_class_father <=", value, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherIn(List<Integer> values) {
            addCriterion("item_class_father in", values, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherNotIn(List<Integer> values) {
            addCriterion("item_class_father not in", values, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherBetween(Integer value1, Integer value2) {
            addCriterion("item_class_father between", value1, value2, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassFatherNotBetween(Integer value1, Integer value2) {
            addCriterion("item_class_father not between", value1, value2, "itemClassFather");
            return (Criteria) this;
        }

        public Criteria andItemClassNameIsNull() {
            addCriterion("item_class_name is null");
            return (Criteria) this;
        }

        public Criteria andItemClassNameIsNotNull() {
            addCriterion("item_class_name is not null");
            return (Criteria) this;
        }

        public Criteria andItemClassNameEqualTo(String value) {
            addCriterion("item_class_name =", value, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameNotEqualTo(String value) {
            addCriterion("item_class_name <>", value, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameGreaterThan(String value) {
            addCriterion("item_class_name >", value, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("item_class_name >=", value, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameLessThan(String value) {
            addCriterion("item_class_name <", value, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameLessThanOrEqualTo(String value) {
            addCriterion("item_class_name <=", value, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameLike(String value) {
            addCriterion("item_class_name like", value, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameNotLike(String value) {
            addCriterion("item_class_name not like", value, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameIn(List<String> values) {
            addCriterion("item_class_name in", values, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameNotIn(List<String> values) {
            addCriterion("item_class_name not in", values, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameBetween(String value1, String value2) {
            addCriterion("item_class_name between", value1, value2, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassNameNotBetween(String value1, String value2) {
            addCriterion("item_class_name not between", value1, value2, "itemClassName");
            return (Criteria) this;
        }

        public Criteria andItemClassDescIsNull() {
            addCriterion("item_class_desc is null");
            return (Criteria) this;
        }

        public Criteria andItemClassDescIsNotNull() {
            addCriterion("item_class_desc is not null");
            return (Criteria) this;
        }

        public Criteria andItemClassDescEqualTo(String value) {
            addCriterion("item_class_desc =", value, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescNotEqualTo(String value) {
            addCriterion("item_class_desc <>", value, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescGreaterThan(String value) {
            addCriterion("item_class_desc >", value, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescGreaterThanOrEqualTo(String value) {
            addCriterion("item_class_desc >=", value, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescLessThan(String value) {
            addCriterion("item_class_desc <", value, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescLessThanOrEqualTo(String value) {
            addCriterion("item_class_desc <=", value, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescLike(String value) {
            addCriterion("item_class_desc like", value, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescNotLike(String value) {
            addCriterion("item_class_desc not like", value, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescIn(List<String> values) {
            addCriterion("item_class_desc in", values, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescNotIn(List<String> values) {
            addCriterion("item_class_desc not in", values, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescBetween(String value1, String value2) {
            addCriterion("item_class_desc between", value1, value2, "itemClassDesc");
            return (Criteria) this;
        }

        public Criteria andItemClassDescNotBetween(String value1, String value2) {
            addCriterion("item_class_desc not between", value1, value2, "itemClassDesc");
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