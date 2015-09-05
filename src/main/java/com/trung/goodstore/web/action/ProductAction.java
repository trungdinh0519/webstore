package com.trung.goodstore.web.action;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import org.springframework.dao.DataAccessException;

import com.trung.goodstore.model.Category;
import com.trung.goodstore.model.Manufacturer;
import com.trung.goodstore.model.Product;
import com.trung.goodstore.persistence.exception.ObjectNotFoundException;
import com.trung.goodstore.service.Manager;
import com.trung.goodstore.service.ProductManager;
import com.trung.goodstore.util.StringUtil;
import com.trung.goodstore.web.form.ProductForm;

public class ProductAction extends BaseDispatchAction {

	public ActionForward addnew(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProductManager manager = (ProductManager) this.getBean("productManager");
		List categories = manager.getCategorys();
		request.getSession().setAttribute("categories", categories);
		List manufacturers = manager.getObjects(Manufacturer.class);
		request.getSession().setAttribute("manufacturers", manufacturers);
		return mapping.findForward("addnew");
	}

	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Manager manager = (Manager) this.getBean("manager");
		String id = request.getParameter("id");
		try {
			manager.removeObject(Product.class, new Long(id));
		} catch (Exception e) {
			e.printStackTrace();
			return new ActionForward("/common/404.jsp");
		}
		return mapping.findForward("listdo");
	}

	public ActionForward save(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		Manager manager = (Manager) this.getBean("manager");
		Product product = new Product();
		ProductForm pForm = (ProductForm) form;
		try {
			this.copyData(pForm, product);
			product.setMdate(new GregorianCalendar().getTime());
			product.setCdate(new GregorianCalendar().getTime());
			try {
				if (StringUtils.isNotEmpty(pForm.getCategory())
						&& StringUtils.isNumeric(pForm.getCategory())) {
					Category c = (Category) manager.getObject(Category.class,
							new Long(pForm.getCategory()));
					System.out.println(pForm.getCategory());
					System.out.println(c);
					product.setCategory(c);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Loi get category");
			}
			try {
				if (StringUtils.isNotEmpty(pForm.getManufacturer())
						&& StringUtils.isNumeric(pForm.getManufacturer())) {
					Manufacturer m = (Manufacturer) manager.getObject(
							Manufacturer.class, new Long(pForm
									.getManufacturer()));
					product.setManufacturer(m);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				System.out.println("Loi get manufacturer");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"error.product.datapopulate"));
			return mapping.getInputForward();

		}
		String uploadDir = servlet.getServletContext().getRealPath("/upload/");
		File dirPath = new File(uploadDir);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		InputStream in = null;
		OutputStream out = null;

		if (pForm.getSmallFile() != null
				&& StringUtils.isNotEmpty(pForm.getSmallFile().getFileName())
				&& StringUtils.isNotBlank(pForm.getSmallFile().getFileName())
				&& pForm.getSmallFile().getFileSize() > 0) {
			try {
				in = pForm.getSmallFile().getInputStream();

				out = new BufferedOutputStream(new FileOutputStream(uploadDir
						+ "\\" + product.getSmallImage()));
				byte[] buffer = new byte[256];
				while (in.read(buffer) != -1) {
					out.write(buffer);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			}

		}
		if (pForm.getMediumFile() != null
				&& StringUtils.isNotEmpty(pForm.getMediumFile().getFileName())
				&& StringUtils.isNotBlank(pForm.getMediumFile().getFileName())
				&& pForm.getMediumFile().getFileSize() > 0) {
			try {
				in = pForm.getMediumFile().getInputStream();
				out = new BufferedOutputStream(new FileOutputStream(uploadDir
						+ "\\" + product.getMediumImage()));
				byte[] buffer = new byte[256];
				while (in.read(buffer) != -1) {
					out.write(buffer);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			}
		}
		if (pForm.getLargeFile() != null
				&& StringUtils.isNotEmpty(pForm.getLargeFile().getFileName())
				&& StringUtils.isNotBlank(pForm.getLargeFile().getFileName())
				&& pForm.getLargeFile().getFileSize() > 0) {
			try {
				in = pForm.getLargeFile().getInputStream();
				out = new BufferedOutputStream(new FileOutputStream(uploadDir
						+ "\\" + product.getLargeImage()));
				byte[] buffer = new byte[256];
				while (in.read(buffer) != -1) {
					out.write(buffer);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			}
		}
		try {
			manager.saveObject(product);
		} catch (DataAccessException daoE) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.databaseaccess.failure"));
			this.saveErrors(request, errors);
			log.debug("Database access error");
			daoE.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");

	}

	public ActionForward edit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String id = request.getParameter("id");
		ProductManager manager = (ProductManager) this.getBean("productManager");
		if (StringUtils.isNotEmpty(id) && StringUtils.isNumeric(id)) {
			try {
				log.debug("************GetID()=" + id);
				Product p = (Product) manager.getObject(Product.class,
						new Long(id));
				log.debug("************GetProduct()=" + p.getName());
				ProductForm productForm = new ProductForm();
				if (p != null) {
					log.debug("*******p ko null********");
					try {
						this.copy(p, productForm);
						log.debug("*******copy thanh cong********");
					} catch (Exception e) {
						log.debug("*******loi copy********");
						e.printStackTrace();
					}
				}
				// System.out.println("******* tiep ********");
				form = productForm;
				if ("request".equals(mapping.getScope())) {
					request.setAttribute(mapping.getAttribute(), form);
				} else {
					request.getSession().setAttribute(mapping.getAttribute(),
							form);
				}
				
				List categories = manager.getCategorys();
				request.getSession().setAttribute("categories", categories);

				List manufacturers = manager.getObjects(Manufacturer.class);
				request.getSession().setAttribute("manufacturers",
						manufacturers);
				return mapping.findForward("edit");
			} catch (ObjectNotFoundException onfe) {
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
						"errors.getProduct.notfound", id));
				this.saveErrors(request, errors);
				return mapping.findForward("listdo");
			}
		} else {
			return new ActionForward("/common/404.jsp");
		}

	}

	public ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (this.isCancelled(request)) {
			return mapping.findForward("success");
		}
		Manager manager = (Manager) this.getBean("manager");
		ProductForm pForm = (ProductForm) form;
		System.out.println("**********ProductId:=" + pForm.getId());
		Product product = (Product) manager.getObject(Product.class, new Long(
				pForm.getId()));
		try {
			this.copyData(pForm, product);
			product.setMdate(new GregorianCalendar().getTime());
			try {
				if (StringUtils.isNotEmpty(pForm.getCategory())
						&& StringUtils.isNumeric(pForm.getCategory())) {
					Category c = (Category) manager.getObject(Category.class,
							new Long(pForm.getCategory()));
					product.setCategory(c);
				}
			} catch (Exception e1) {
				e1.printStackTrace();
				System.out.println("Loi get category");
			}
			try {
				if (StringUtils.isNotEmpty(pForm.getManufacturer())
						&& StringUtils.isNumeric(pForm.getManufacturer())) {
					Manufacturer m = (Manufacturer) manager.getObject(
							Manufacturer.class, new Long(pForm
									.getManufacturer()));
					product.setManufacturer(m);
				}
			} catch (Exception e2) {
				e2.printStackTrace();
				log.debug("Loi get manufacturer");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		String uploadDir = servlet.getServletContext().getRealPath("/upload/");
		File dirPath = new File(uploadDir);
		if (!dirPath.exists()) {
			dirPath.mkdirs();
		}
		InputStream in = null;
		OutputStream out = null;
		// System.out.println("**************smallfile
		// name="+pForm.getSmallFile().getFileName());
		if (pForm.getSmallFile() != null
				&& StringUtils.isNotEmpty(pForm.getSmallFile().getFileName())
				&& StringUtils.isNotBlank(pForm.getSmallFile().getFileName())
				&& pForm.getSmallFile().getFileSize() > 0) {
			try {
				in = pForm.getSmallFile().getInputStream();

				out = new BufferedOutputStream(new FileOutputStream(uploadDir
						+ "\\" + product.getSmallImage()));
				byte[] buffer = new byte[256];
				while (in.read(buffer) != -1) {
					out.write(buffer);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			}

		}
		if (pForm.getMediumFile() != null
				&& StringUtils.isNotEmpty(pForm.getMediumFile().getFileName())
				&& StringUtils.isNotBlank(pForm.getMediumFile().getFileName())
				&& pForm.getMediumFile().getFileSize() > 0) {
			try {
				in = pForm.getMediumFile().getInputStream();
				out = new BufferedOutputStream(new FileOutputStream(uploadDir
						+ "\\" + product.getMediumImage()));
				byte[] buffer = new byte[256];
				while (in.read(buffer) != -1) {
					out.write(buffer);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			}
		}
		if (pForm.getLargeFile() != null
				&& StringUtils.isNotEmpty(pForm.getLargeFile().getFileName())
				&& StringUtils.isNotBlank(pForm.getLargeFile().getFileName())
				&& pForm.getLargeFile().getFileSize() > 0) {
			try {
				in = pForm.getLargeFile().getInputStream();
				out = new BufferedOutputStream(new FileOutputStream(uploadDir
						+ "\\" + product.getLargeImage()));
				byte[] buffer = new byte[256];
				while (in.read(buffer) != -1) {
					out.write(buffer);
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			} finally {
				if (out != null)
					out.close();
				if (in != null)
					in.close();
			}
		}
		try {
			manager.saveObject(product);
		} catch (DataAccessException daoE) {
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage(
					"errors.databaseaccess.failure"));
			this.saveErrors(request, errors);
			log.debug("Database access error");
			daoE.printStackTrace();
			return mapping.getInputForward();
		}
		return mapping.findForward("success");
	}

	public ActionForward search(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String keyword = request.getParameter("keyword");
		String cateId = request.getParameter("cateId");
		ProductManager pmrg = (ProductManager) this.getBean("productManager");
		Integer pageSize = 20;
		int pos = 0;
		String id = request.getParameter(new ParamEncoder("row")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE));
		if (StringUtils.isNotEmpty(id)) {
			System.out.println("ID page=" + id);
			pos = (Integer.valueOf(id) - 1) * pageSize;
		}
		List products = pmrg.search(keyword, cateId, pos, pageSize);
		Integer resultSize = pmrg.getTotalSearch(keyword, cateId);
		request.setAttribute("resultSize", resultSize);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("products", products);
		Manager manager = (Manager) this.getBean("manager");
		List categories = manager.getObjects(Category.class);
		request.getSession().setAttribute("categories", categories);

		return mapping.findForward("list");

	}

	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ProductManager pMrg = (ProductManager) this.getBean("productManager");
		Integer resultSize = (int) pMrg.getNumberProduct();
		Integer pageSize = 20;
		int pos = 0;
		String id = request.getParameter(new ParamEncoder("row")
				.encodeParameterName(TableTagParameters.PARAMETER_PAGE));
		if (StringUtils.isNotEmpty(id)) {
			System.out.println("ID page=" + id);
			pos = (Integer.valueOf(id) - 1) * pageSize;
		}
		List products = pMrg.getProduct(pos, pageSize);
		request.setAttribute("resultSize", resultSize);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("products", products);
		Manager manager = (Manager) this.getBean("manager");
		List categories = manager.getObjects(Category.class);
		request.getSession().setAttribute("categories", categories);
		return mapping.findForward("list");
	}

	private void copyData(ProductForm form, Product product) throws Exception {
		try {
			NumberFormat perf = NumberFormat.getPercentInstance();
			DecimalFormat numbf = new DecimalFormat();
			numbf.setGroupingUsed(false);
			numbf.setMaximumFractionDigits(2);

			product.setName(form.getName());
			product.setSort_desc(form.getSort_desc());
			if (StringUtils.isNotEmpty(form.getStock().trim()))
				product.setStock(new Long(form.getStock().trim()));
			else product.setStock(new Long(0));
			product.setUnit(form.getUnit());
			if (StringUtils.isNotEmpty(form.getUnitPrice().trim()))
				product.setUnitPrice(new Double(form.getUnitPrice().trim()));
			else product.setUnitPrice(new Double(0.0));
			if (StringUtils.isNotEmpty(form.getWidth().trim()))
				product.setWidth(new Double(form.getWidth().trim()));
			else product.setWidth(new Double(0.0));
			if (!form.getWeight().trim().equals(""))
				product.setWeight(new Double(form.getWeight().trim()));
			else product.setWeight(new Double(0.0));
			product.setTaxed(form.getTaxed());
			product.setActive(form.getActive());

			product.setDesc(form.getDesc());
			if (StringUtils.isNotEmpty(form.getDiscount().trim()))
				product.setDiscount(perf.parse(form.getDiscount().trim())
						.doubleValue());
			if (StringUtils.isNotEmpty(form.getHeight().trim()))
				product.setHeight(numbf.parse(form.getHeight().trim())
						.doubleValue());
			else product.setHeight(0.0);
			if (StringUtils.isNotEmpty(form.getLength().trim()))
				product.setLength(numbf.parse(form.getLength().trim())
						.doubleValue());
			else product.setLength(0.0);
			String random = String.valueOf((1000000 * Math.random()));
			//System.out.println(random);
			if (form.getSmallFile() != null
					&& StringUtils
							.isNotEmpty(form.getSmallFile().getFileName())
					&& StringUtils
							.isNotBlank(form.getSmallFile().getFileName())
					&& form.getSmallFile().getFileSize() > 0) {
				String fileName = form.getSmallFile().getFileName();
				if (fileName.lastIndexOf(".") >= 0)
					fileName = StringUtil.encodePassword(fileName + random,
							"SHA")
							+ fileName.substring(fileName.lastIndexOf("."));
				else
					fileName = StringUtil.encodePassword(fileName + random,
							"SHA");
				product.setSmallImage(fileName);
				System.out.println(product.getSmallImage());
			} else
				product.setSmallImage(form.getSmallImage());

			if (form.getMediumFile() != null
					&& StringUtils.isNotEmpty(form.getMediumFile()
							.getFileName())
					&& StringUtils.isNotBlank(form.getMediumFile()
							.getFileName())
					&& form.getMediumFile().getFileSize() > 0) {
				String fileName = form.getMediumFile().getFileName();
				if (fileName.lastIndexOf(".") >= 0)
					fileName = StringUtil.encodePassword(fileName + random,
							"SHA")
							+ fileName.substring(fileName.lastIndexOf("."));
				else
					fileName = StringUtil.encodePassword(fileName + random,
							"SHA");
				product.setMediumImage(fileName);

			} else
				product.setMediumImage(form.getMediumImage());

			if (form.getLargeFile() != null
					&& StringUtils
							.isNotEmpty(form.getLargeFile().getFileName())
					&& StringUtils
							.isNotBlank(form.getLargeFile().getFileName())
					&& form.getLargeFile().getFileSize() > 0) {
				String fileName = form.getLargeFile().getFileName();
				if (fileName.lastIndexOf(".") >= 0)
					fileName = StringUtil.encodePassword(fileName + random,
							"SHA")
							+ fileName.substring(fileName.lastIndexOf("."));
				else
					fileName = StringUtil.encodePassword(fileName + random,
							"SHA");
				product.setLargeImage(fileName);

			} else
				product.setLargeImage(form.getLargeImage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}

	}

	private void copy(Product product, ProductForm form) throws Exception {
		NumberFormat perf = NumberFormat.getPercentInstance();
		DecimalFormat numbf = new DecimalFormat();
		numbf.setGroupingUsed(false);
		numbf.setMaximumFractionDigits(3);

		form.setLargeImage(product.getLargeImage());
		form.setMediumImage(product.getMediumImage());
		form.setName(product.getName());
		form.setSmallImage(product.getSmallImage());
		form.setSort_desc(product.getSort_desc());
		form.setDesc(product.getDesc());
		form.setActive(product.getActive());
		form.setId(product.getId().toString());
		form.setTaxed(product.getTaxed());
		form.setUnit(product.getUnit());
		if (product.getLength() != null)
			form.setLength(numbf.format(product.getLength()));
		if (product.getHeight() != null)
			form.setHeight(numbf.format(product.getHeight()));
		if (product.getUnitPrice() != null)
			form.setUnitPrice(numbf.format(product.getUnitPrice()));
		if (product.getWeight() != null)
			form.setWeight(numbf.format(product.getWeight()));
		if (product.getWidth() != null)
			form.setWidth(numbf.format(product.getWidth()));
		if (product.getStock() != null)
			form.setStock(numbf.format(product.getStock()));
		if (product.getDiscount() != null)
			form.setDiscount(perf.format(product.getDiscount()));
		if (product.getCategory() != null)
			form.setCategory(product.getCategory().getId().toString());
		if (product.getManufacturer() != null)
			form.setManufacturer(product.getManufacturer().getId().toString());

	}
}
