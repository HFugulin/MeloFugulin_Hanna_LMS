// Hanna Melo Fugulin - July 7th 2024 - CEN-3024C-33022
// 202430 Software Development I, Professor Walauskis

package DBHelper;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * This class handles database operations for the BooksLMS table in the SQLite database.
 */
public class BooksLMS extends DBHelper {
	private final String TABLE_NAME = "BooksLMS";
	public static final String Title = "Title";
	public static final String Author = "Author";
	public static final String Genre = "Genre";
	public static final String Barcode = "Barcode";
	public static final String Status = "Status";
	public static final String DueDate = "DueDate";

	/**
	 * Prepares an SQL query string.
	 *
	 * @param fields the fields to select
	 * @param whatField the field for the where clause
	 * @param whatValue the value for the where clause
	 * @param sortField the field to sort by
	 * @param sort the sort order
	 * @return the prepared SQL query string
	 */
	private String prepareSQL(String fields, String whatField, String whatValue, String sortField, String sort) {
		String query = "SELECT ";
		query += fields == null ? " * FROM " + TABLE_NAME : fields + " FROM " + TABLE_NAME;
		query += whatField != null && whatValue != null ? " WHERE " + whatField + " = \"" + whatValue + "\"" : "";
		query += sort != null && sortField != null ? " order by " + sortField + " " + sort : "";
		return query;
	}
	/**
	 * Inserts a new book into the database.
	 *
	 * @param Title the title of the book
	 * @param Author the author of the book
	 * @param Genre the genre of the book
	 * @param Barcode the barcode of the book
	 * @param Status the status of the book
	 * @param DueDate the due date of the book
	 */
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

	/**
	 * Deletes a book from the database based on a specific field and value.
	 *
	 * @param field the field to match
	 * @param value the value to match
	 */
	public void delete(String whatField, String whatValue) {
		super.execute("DELETE from " + TABLE_NAME + " where " + whatField + " = " + whatValue + ";");
	}

	/**
	 * Updates a specific field of a book in the database.
	 *
	 * @param field the field to update
	 * @param value the new value
	 * @param whereField the field to match in the where clause
	 * @param whereValue the value to match in the where clause
	 */
	public void update(String whatField, String whatValue, String whereField, String whereValue) {
		super.execute("UPDATE " + TABLE_NAME + " set " + whatField + " = " + whatValue + " where " + whereField + " = " + whereValue + ";");
	}

	/**
	 * Selects books from the database based on specified criteria.
	 *
	 * @param fields the fields to select
	 * @param whatField the field for the where clause
	 * @param whatValue the value for the where clause
	 * @param sortField the field to sort by
	 * @param sort the sort order
	 * @return a list of books that match the criteria
	 */
	public ArrayList<ArrayList<Object>> select(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQuery(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

	public ArrayList<ArrayList<Object>> getExecuteResult(String query) {
		return super.executeQuery(query);
	}

	/**
	 * Returns a table model for displaying the books in a table.
	 *
	 * @return the table model
	 */
	public void execute(String query) {
		super.execute(query);
	}

	public DefaultTableModel selectToTable(String fields, String whatField, String whatValue, String sortField, String sort) {
		return super.executeQueryToTable(prepareSQL(fields, whatField, whatValue, sortField, sort));
	}

}