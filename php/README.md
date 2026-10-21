# Slot Machine Simulator API - PHP Package

Slot Machine Simulator generates slot machine reel spins for configurable reels, bet sizes, and spin counts. Every run outputs symbol names and emoji for each reel; paid plans add payout calculations, win tracking, and net profit statistics.

## Installation

Install via Composer:

```bash
composer require apiverve/slotmachine
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Slotmachine\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute([
    'spins' => 1,
    'reels' => 3,
    'bet' => 1
]);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Slotmachine\Client;
use APIVerve\Slotmachine\Exceptions\APIException;
use APIVerve\Slotmachine\Exceptions\ValidationException;

try {
    $response = $client->execute(['spins' => 1, 'reels' => 3, 'bet' => 1]);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "total_spins": 5,
    "num_reels": 3,
    "bet_per_spin": 1,
    "spins": [
      {
        "spin_number": 1,
        "reels": [
          {
            "symbol": "🍋",
            "name": "Lemon"
          },
          {
            "symbol": "🍒",
            "name": "Cherry"
          },
          {
            "symbol": "🍒",
            "name": "Cherry"
          }
        ],
        "bet": 1,
        "payout": 0,
        "win_type": "none",
        "is_win": false
      },
      {
        "spin_number": 2,
        "reels": [
          {
            "symbol": "⭐",
            "name": "Star"
          },
          {
            "symbol": "🍋",
            "name": "Lemon"
          },
          {
            "symbol": "⭐",
            "name": "Star"
          }
        ],
        "bet": 1,
        "payout": 0,
        "win_type": "none",
        "is_win": false
      },
      {
        "spin_number": 3,
        "reels": [
          {
            "symbol": "🍊",
            "name": "Orange"
          },
          {
            "symbol": "🍇",
            "name": "Grape"
          },
          {
            "symbol": "🍋",
            "name": "Lemon"
          }
        ],
        "bet": 1,
        "payout": 0,
        "win_type": "none",
        "is_win": false
      },
      {
        "spin_number": 4,
        "reels": [
          {
            "symbol": "🍒",
            "name": "Cherry"
          },
          {
            "symbol": "⭐",
            "name": "Star"
          },
          {
            "symbol": "🔔",
            "name": "Bell"
          }
        ],
        "bet": 1,
        "payout": 0,
        "win_type": "none",
        "is_win": false
      },
      {
        "spin_number": 5,
        "reels": [
          {
            "symbol": "🍒",
            "name": "Cherry"
          },
          {
            "symbol": "🍒",
            "name": "Cherry"
          },
          {
            "symbol": "7️⃣",
            "name": "Seven"
          }
        ],
        "bet": 1,
        "payout": 0.5,
        "win_type": "small",
        "is_win": true
      }
    ],
    "total_bet": 5,
    "total_winnings": 0.5,
    "net_profit": -4.5,
    "wins": 1,
    "losses": 4,
    "win_percentage": 20,
    "available_symbols": [
      {
        "symbol": "🍒",
        "name": "Cherry",
        "payout_multiplier": 2
      },
      {
        "symbol": "🍋",
        "name": "Lemon",
        "payout_multiplier": 3
      },
      {
        "symbol": "🍊",
        "name": "Orange",
        "payout_multiplier": 5
      },
      {
        "symbol": "🍇",
        "name": "Grape",
        "payout_multiplier": 10
      },
      {
        "symbol": "🔔",
        "name": "Bell",
        "payout_multiplier": 20
      },
      {
        "symbol": "⭐",
        "name": "Star",
        "payout_multiplier": 50
      },
      {
        "symbol": "💎",
        "name": "Diamond",
        "payout_multiplier": 100
      },
      {
        "symbol": "7️⃣",
        "name": "Seven",
        "payout_multiplier": 200
      }
    ]
  }
}
```

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/slotmachine?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/slotmachine?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/slotmachine?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
