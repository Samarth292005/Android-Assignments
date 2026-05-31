
        
            
    }

    
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
