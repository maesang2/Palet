package Trillion.Palet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Trillion.Palet.DAO.AdminDAO;
import Trillion.Palet.DTO.AdminDTO;
import Trillion.Palet.DTO.CancelDTO;
import Trillion.Palet.DTO.ExhibitionDTO;
import Trillion.Palet.DTO.GoodsDTO;
import Trillion.Palet.DTO.MemberDTO;
import Trillion.Palet.DTO.ProgramDTO;
import Trillion.Palet.DTO.SalesDTO;
import Trillion.Palet.DTO.TotalPaymentDTO;

@Service
public class AdminService {
		
	@Autowired
	private AdminDAO adao;
	
	// Member Category
	
	public List<MemberDTO> memberSelectByPage(int cpage){
		return adao.memberSelectByPage(cpage);
	}
	
	public String getMemberPageNavi(int cpage) {
		return adao.getMemberPageNavi(cpage);
	}
	
	public int getMemberTotalCount() {
		return adao.getMemberTotalCount();
	}
	
	public void adminMemberModi(MemberDTO dto) {
		adao.adminMemberModi(dto);
	}
	
	public void adminMemberBan(String email) {
		adao.adminMemberBan(email);
	}
	
	public int memberCheckDelete(String email) {
		return adao.adminMemberBan(email);
	}
	
	public int memberCheckUpdate (String email, String grade) {
		return adao.memberCheckUpdate(email, grade);
	}
	
	public List<AdminDTO> getMemberPayment(String email) {
		return adao.getMemberPayment(email);
	}
	
	// Exhibition Category
	
	public List<ExhibitionDTO> exhibitionSelectByPage(int cpage, String value){
		return adao.exhibitionSelectByPage(cpage, value);
	}
	
	public String getExhibitionPageNavi(int cpage) {
		return adao.getExhibitionPageNavi(cpage);
	}
	
	public void adminExhibitionUpdate(ExhibitionDTO edto) {
		adao.adminExhibitionUpdate(edto);
	}
	
	
	// Goods Category
	
	public List<GoodsDTO> goodsSelectByPage(int cpage){
		return adao.goodsSelectByPage(cpage);
	}
	
	public List<GoodsDTO> goodsJoinSelectByPage(int cpage, String value){
		return adao.goodsJoinSelectByPage(cpage, value);
	}
	
	public String getGoodsPageNavi(int cpage) {
		return adao.getGoodsPageNavi(cpage);
	}
	
	public String getGoodsJoinPageNavi(int cpage) {
		return adao.getGoodsJoinPageNavi(cpage);
	}
	
	public int goodsCheckDelelte (int g_num) {
		return adao.goodsCheckDelete(g_num);
	}
	
	public int goodsCheckUpdate (String g_num, String e_num) {
		return adao.goodsCheckUpdate(g_num, e_num);
	}
	
	public void adminGoodsUpdate(GoodsDTO gdto) {
		adao.adminGoodsUpdate(gdto);
	}
	
	// Program Category
	
	public List<ProgramDTO> programSelectByPage(int cpage, String value){
		return adao.programSelectByPage(cpage, value);
	}
	
	public String getProgramPageNavi(int cpage) {
		return adao.getProgramPageNavi(cpage);
	}
	
	// Payment Category
	
	public List<TotalPaymentDTO> paymentSelectUIDByPage(int cpage, String uid){
		return adao.paymentSelectUIDByPage(cpage, uid);
	}
	
	public String getPaymentUIDPageNavi(int cpage, String search) {
		return adao.getPaymentUIDPageNavi(cpage, search);
	}
	
	public List<TotalPaymentDTO> paymentSelectNameByPage(int cpage, String name){
		return adao.paymentSelectNameByPage(cpage, name);
	}
	
	public String getPaymentNamePageNavi(int cpage, String search) {
		return adao.getPaymentNamePageNavi(cpage, search);
	}
	
	public List<TotalPaymentDTO> paymentSelectByPage(int cpage){
		return adao.paymentSelectByPage(cpage);
	}
	
	public String getPaymentPageNavi(int cpage) {
		return adao.getPaymentPageNavi(cpage);
	}
	
	public AdminDTO getAdminPayDetail(String merchant_uid) {
		return adao.getAdminPayDetail(merchant_uid);
	}
	
	public AdminDTO getAdminExticketDetail(String merchant_uid) {
		return adao.getAdminExticketDetail(merchant_uid);
	}
	
	public AdminDTO getAdminProticketDetail(String merchant_uid) {
		return adao.getAdminProticketDetail(merchant_uid);
	}
	
	// Payment > Cancel
	
	public List<CancelDTO> cancelSelectByPage(int cpage){
		return adao.cancelSelectByPage(cpage);
	}
	
	public String getCancelPageNavi(int cpage) {
		return adao.getCancelPageNavi(cpage);
	}
	
	public String categoryCheck(String check) {
		return adao.categoryCheck(check);
	}
	
	public int cancelExticketUpdate(String check) {
		return adao.cancelExticketUpdate(check);
	}
	
	public int cancelGoodsUpdate(String check) {
		return adao.cancelGoodsUpdate(check);
	}
	
	public int cancelProticketUpdate(String check) {
		return adao.cancelProticketUpdate(check);
	}
	
	public int cancelPaymentCheckDelete(String check) {
		return adao.cancelPaymentCheckDelete(check);	
	}
	
	public void cancelExAfterWorks(String check) {
		adao.restoreExCountAndStock(check);
		
		int result = adao.checkUsedExPoint(check);
		
		if (result != 0) {
			adao.restoreExPoint(check);
		}
		
	}
	
	public void cancelGoodsAfterWorks(String check) {
		adao.restoreGoodsCountAndStock(check);
		
		int result = adao.checkUsedGoodsPoint(check);
		
		if (result != 0) {
			adao.restoreGoodsPoint(check);
		}
		
	}
	
	public void cancelProAfterWorks (String check)  {
		adao.restoreProCountAndStock(check);
		
		int result = adao.checkUsedProPoint(check);
		
		if(result != 0) {
			adao.restoreProPoint(check);
		}
	}

	
	// etc..
	
	public List<SalesDTO> getWeekSales(){
		return adao.getWeekSales();
	}
	
	public List<SalesDTO> getWeekCount(){
		return adao.getWeekCount();
	}
	
}

