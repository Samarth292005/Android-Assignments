
        toCurrency = findViewById(R.id.toCurrency);
        convertBtn = findViewById(R.id.convertBtn);
        result = findViewById(R.id.result);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, currencies);

        fromCurrency.setAdapter(adapter);
        toCurrency.setAdapter(adapter);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double input = Double.parseDouble(amount.getText().toString());

                String from = fromCurrency.getSelectedItem().toString();
                String to = toCurrency.getSelectedItem().toString();

                double converted = convertCurrency(from, to, input);

                result.setText("Converted: " + converted);
            }
        });
    }

    private double convertCurrency(String from, String to, double amount) {

        // Convert everything to INR first
        double inr = 0;

        switch (from) {
            case "INR": inr = amount; break;
            case "USD": inr = amount * 83; break;
            case "EUR": inr = amount * 90; break;
            case "JPY": inr = amount * 0.55; break;
        }

        // Convert INR to target
        switch (to) {
            case "INR": return inr;
            case "USD": return inr / 83;
            case "EUR": return inr / 90;
            case "JPY": return inr / 0.55;
        }

        return 0;
    }
}
