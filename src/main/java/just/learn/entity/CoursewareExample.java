package just.learn.entity;

import java.util.ArrayList;
import java.util.List;

public class CoursewareExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CoursewareExample() {
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

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesIsNull() {
            addCriterion("downlaod_times is null");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesIsNotNull() {
            addCriterion("downlaod_times is not null");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesEqualTo(Integer value) {
            addCriterion("downlaod_times =", value, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesNotEqualTo(Integer value) {
            addCriterion("downlaod_times <>", value, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesGreaterThan(Integer value) {
            addCriterion("downlaod_times >", value, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesGreaterThanOrEqualTo(Integer value) {
            addCriterion("downlaod_times >=", value, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesLessThan(Integer value) {
            addCriterion("downlaod_times <", value, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesLessThanOrEqualTo(Integer value) {
            addCriterion("downlaod_times <=", value, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesIn(List<Integer> values) {
            addCriterion("downlaod_times in", values, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesNotIn(List<Integer> values) {
            addCriterion("downlaod_times not in", values, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesBetween(Integer value1, Integer value2) {
            addCriterion("downlaod_times between", value1, value2, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andDownlaodTimesNotBetween(Integer value1, Integer value2) {
            addCriterion("downlaod_times not between", value1, value2, "downlaodTimes");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andUrlIsNull() {
            addCriterion("url is null");
            return (Criteria) this;
        }

        public Criteria andUrlIsNotNull() {
            addCriterion("url is not null");
            return (Criteria) this;
        }

        public Criteria andUrlEqualTo(String value) {
            addCriterion("url =", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotEqualTo(String value) {
            addCriterion("url <>", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThan(String value) {
            addCriterion("url >", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlGreaterThanOrEqualTo(String value) {
            addCriterion("url >=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThan(String value) {
            addCriterion("url <", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLessThanOrEqualTo(String value) {
            addCriterion("url <=", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlLike(String value) {
            addCriterion("url like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotLike(String value) {
            addCriterion("url not like", value, "url");
            return (Criteria) this;
        }

        public Criteria andUrlIn(List<String> values) {
            addCriterion("url in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotIn(List<String> values) {
            addCriterion("url not in", values, "url");
            return (Criteria) this;
        }

        public Criteria andUrlBetween(String value1, String value2) {
            addCriterion("url between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andUrlNotBetween(String value1, String value2) {
            addCriterion("url not between", value1, value2, "url");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNull() {
            addCriterion("is_pass is null");
            return (Criteria) this;
        }

        public Criteria andIsPassIsNotNull() {
            addCriterion("is_pass is not null");
            return (Criteria) this;
        }

        public Criteria andIsPassEqualTo(String value) {
            addCriterion("is_pass =", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotEqualTo(String value) {
            addCriterion("is_pass <>", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThan(String value) {
            addCriterion("is_pass >", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassGreaterThanOrEqualTo(String value) {
            addCriterion("is_pass >=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThan(String value) {
            addCriterion("is_pass <", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLessThanOrEqualTo(String value) {
            addCriterion("is_pass <=", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassLike(String value) {
            addCriterion("is_pass like", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotLike(String value) {
            addCriterion("is_pass not like", value, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassIn(List<String> values) {
            addCriterion("is_pass in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotIn(List<String> values) {
            addCriterion("is_pass not in", values, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassBetween(String value1, String value2) {
            addCriterion("is_pass between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andIsPassNotBetween(String value1, String value2) {
            addCriterion("is_pass not between", value1, value2, "isPass");
            return (Criteria) this;
        }

        public Criteria andCourseCapIsNull() {
            addCriterion("course_cap is null");
            return (Criteria) this;
        }

        public Criteria andCourseCapIsNotNull() {
            addCriterion("course_cap is not null");
            return (Criteria) this;
        }

        public Criteria andCourseCapEqualTo(String value) {
            addCriterion("course_cap =", value, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapNotEqualTo(String value) {
            addCriterion("course_cap <>", value, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapGreaterThan(String value) {
            addCriterion("course_cap >", value, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapGreaterThanOrEqualTo(String value) {
            addCriterion("course_cap >=", value, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapLessThan(String value) {
            addCriterion("course_cap <", value, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapLessThanOrEqualTo(String value) {
            addCriterion("course_cap <=", value, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapLike(String value) {
            addCriterion("course_cap like", value, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapNotLike(String value) {
            addCriterion("course_cap not like", value, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapIn(List<String> values) {
            addCriterion("course_cap in", values, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapNotIn(List<String> values) {
            addCriterion("course_cap not in", values, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapBetween(String value1, String value2) {
            addCriterion("course_cap between", value1, value2, "courseCap");
            return (Criteria) this;
        }

        public Criteria andCourseCapNotBetween(String value1, String value2) {
            addCriterion("course_cap not between", value1, value2, "courseCap");
            return (Criteria) this;
        }

        public Criteria andHandleTypeIsNull() {
            addCriterion("handle_type is null");
            return (Criteria) this;
        }

        public Criteria andHandleTypeIsNotNull() {
            addCriterion("handle_type is not null");
            return (Criteria) this;
        }

        public Criteria andHandleTypeEqualTo(String value) {
            addCriterion("handle_type =", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeNotEqualTo(String value) {
            addCriterion("handle_type <>", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeGreaterThan(String value) {
            addCriterion("handle_type >", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeGreaterThanOrEqualTo(String value) {
            addCriterion("handle_type >=", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeLessThan(String value) {
            addCriterion("handle_type <", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeLessThanOrEqualTo(String value) {
            addCriterion("handle_type <=", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeLike(String value) {
            addCriterion("handle_type like", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeNotLike(String value) {
            addCriterion("handle_type not like", value, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeIn(List<String> values) {
            addCriterion("handle_type in", values, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeNotIn(List<String> values) {
            addCriterion("handle_type not in", values, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeBetween(String value1, String value2) {
            addCriterion("handle_type between", value1, value2, "handleType");
            return (Criteria) this;
        }

        public Criteria andHandleTypeNotBetween(String value1, String value2) {
            addCriterion("handle_type not between", value1, value2, "handleType");
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