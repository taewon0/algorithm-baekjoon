import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		ZonedDateTime zdt = LocalDate.of(2007, m, d).atStartOfDay(ZoneId.of("Asia/Seoul"));
		DayOfWeek day = zdt.getDayOfWeek();
		String result = day.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
		System.out.println(result.toUpperCase());
	}

}
