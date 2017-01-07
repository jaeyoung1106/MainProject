package style.member.user.model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MemberVO {
	private String id;// ȸ�����̵�
	private String password;// ȸ�� ��й�ȣ
	private String pass_quest;// ��й�ȣ ����
	private String pass_answer;// ��й�ȣ �亯
	private String name;// ȸ�� �̸�
	private String zipcode;// �����ȣ
	private String address1;// �ּ�1
	private String address2;// ���ּ�
	private String email;// �̸���
	private String birth;// ������� --> jsp <input type=date>���� ������ ���� ���ڿ��� ����
							// ������� ������ Ÿ�� ó���� �ؿ� getter���� ó����
	
	private String body;// ü��
	private int height;// Ű
	private int gender;// ����
	private int point;// ���� ����Ʈ
	private Date regdate;// ��ϳ�¥ --> ȸ������ ��ȸ�Ҷ� DB���� sql.DateŸ������ �����µ�
						// ȭ�鿡 �����ٶ� ������Ÿ���� �ٲ���Ѵ�. �ؿ� setter���� ó�� ����
						// ó�� ȸ�� ����Ҷ� null������ ������ DB�� �⺻���� �ȸԾ �ؿ� getter���� ���ó�¥ ó����

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPass_quest() {
		return pass_quest;
	}

	public void setPass_quest(String pass_quest) {
		this.pass_quest = pass_quest;
	}

	public String getPass_answer() {
		return pass_answer;
	}

	public void setPass_answer(String pass_answer) {
		this.pass_answer = pass_answer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirth() {
		Date sqlBirth = null;
		java.util.Date utilDate = null;
		SimpleDateFormat format = null;
		try {
			// date ��¥ ó�� String-> util.date -> sql.date
			format = new SimpleDateFormat("yyyy-MM-dd");
			utilDate = format.parse(this.birth);
			sqlBirth = new Date(utilDate.getTime());
		} catch (Exception e) {

		}
		return sqlBirth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public Date getRegdate() {
		// ���ó�¥�� �������ִ� ó��
		
		//���ó�¥(�ڹ� ��ƿ)
		java.util.Date today = new java.util.Date();
		
		//sqlDate�������� �ٲپ� ��ȯ
		return new Date(today.getTime());
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

}
