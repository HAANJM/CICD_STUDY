package com.ssafy.ssafitlog.model.dto;


// 유저의 스트릭 경험치 변동값을 유저의 경험치 총합에 적용하기 위한 dto
public class StricExpDiff extends Exp{
	private int diffStricExp; // 평가나 게시글 등록 등으로 인해 생긴 stricExp 차이

	public StricExpDiff() {
		super();
	}
	
	public int getDiffStricExp() {
		return diffStricExp;
	}

	public void setDiffStricExp(int diffStricExp) {
		this.diffStricExp = diffStricExp;
	}

	@Override
	public String toString() {
		return "StricExpDiff [diffStricExp=" + diffStricExp + ", getDiffStricExp()=" + getDiffStricExp()
				+ ", getUserId()=" + getUserId() + ", getRegDate()=" + getRegDate() + ", getReviewExp()="
				+ getReviewExp() + ", getStricExp()=" + getStricExp() + ", toString()=" + super.toString()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
