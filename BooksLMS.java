// Hanna Melo Fugulin - July 11th 2024 - CEN-3024C-33022
// 202430 Software Development I, Professor Walauskis

package DBHelper;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class BooksLMS extends DBHelper {
	private final String TABLE_NAME = "BooksLMS";
	public static final String Title = "Title";
	public static final String Author = "Author";
	public static final String Genre = "Genre";
	public static final String Barcode = "Barcode";
	public static final String Status = "Status";
	public static final String DueDate = "DueDate";

	private String prepareSQL(String fields, String whatField, String whatValue, String sortField, String sort) {
		String query = "SELECT ";
		query += fields == null ? " * FROM " + TABLE_NAME : fields + " FROM " + TABLE_NAME;
		query += whatField != null && whatValue != null ? " WHERE " + whatField + " = \"" + whatValue + "\"" : "";
		query += sort != null && sortField != null ? " order by " + sortField + " " + sort : "";
		return query;
	}

	public void insert(String Title, String Author, String Genre, String Barcode, String Status, String DueDate) {
		Title = Title != null ? "\"" + Title + "\"" : null;
		Author = Author != null ? "\"" + Author + "\"" : null;
		Genre = Genre != null ? "\"" + Genre + "\"" : null;
		Barcode = Barcode != null ? "\"" + Barcode + "\"" : null;
		Status = Status != null ? "\"" + Status + "\"" : null;
		DueDate = DueDate != null ? "\"" + DueDate + "\"" : null;
		
		Object[] values_ar = {Title, Author, Genre, Barcode, Status, DueDate};
		String[] fields_ar = {BooksLMS.Title, BooksLMS.Author, BooksLMS.Genre, BooksLMS.Barcode, BooksLMS.Status, BooksLMS.DueDate};
		String values = "", fields = "";
		for (int i = 0; i < values_ar.length; i++) {
			if (values_ar[i] != null) {
				values += values_ar[i] + ", ";
				fields += fields_ar[i] + ", ";
			}
		}
		if (!values.isEmpty()) {
			values = values.substring(0, values.length() - 2);
			fields = fields.substring(0, fields.length() - 2);
			super.execute("INSERT INTO " + TABLE_NAME + "(" + fields + ") values(" + values + ");");
		}
	}

	public void delete(String whatField, String whatValue) {
		super.execute("DELETE from " + TABLE_NAME + " where " + whatField + " = " + whatValue + ";");
	}

	public void update(String whatField, String whatValue, String whereField, String whereValue) {
		super.execute("UPDATE " + TABLE_NAME + " set " + whatField + " = " + whatValue + " where " + whereField + " = " + whereValue + ";");
	}

	public ArrayList<ArrayList<Object>> select(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQuery(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

	public ArrayList<ArrayList<Object>> getExecuteResult(String query) {
		return super.executeQuery(query);
	}

	public void execute(String query) {
		super.execute(query);
	}

	public DefaultTableModel selectToTable(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQueryToTable(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

}