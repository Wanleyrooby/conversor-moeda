import java.util.Map;

public record TaxasDeCambio(String base_code, Map<String, Double> conversion_rates) {
}
