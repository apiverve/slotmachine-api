Slot Machine Simulator API
============

Slot Machine Simulator generates slot machine reel spins for configurable reels, bet sizes, and spin counts. Every run outputs symbol names and emoji for each reel; paid plans add payout calculations, win tracking, and net profit statistics.


[![PyPI version](https://img.shields.io/pypi/v/apiverve-slotmachinesimulator.svg)](https://pypi.org/project/apiverve-slotmachinesimulator/)

This is a Python wrapper for the [Slot Machine Simulator API](https://apiverve.com/marketplace/slotmachine?utm_source=pypi&utm_medium=referral&utm_content=readme)

---

## Installation

Using `pip`:

```bash
pip install apiverve-slotmachinesimulator
```

Using `pip3`:

```bash
pip3 install apiverve-slotmachinesimulator
```

---

## Configuration

Before using the Slot Machine Simulator API client, you have to setup your account and obtain your API Key.
You can get it by signing up at [https://apiverve.com](https://apiverve.com?utm_source=pypi&utm_medium=referral&utm_content=readme)

---

## Quick Start

Here's a simple example to get you started quickly:

```python
from apiverve_slotmachinesimulator.apiClient import SlotmachineAPIClient

# Initialize the client with your APIVerve API key
api = SlotmachineAPIClient("[YOUR_API_KEY]")

query = {
    "spins": 1,
    "reels": 3,
    "bet": 1
}

try:
    # Make the API call
    result = api.execute(query)

    # Print the result
    print(result)
except Exception as e:
    print(f"Error: {e}")
```

---

## Usage

The Slot Machine Simulator API documentation is found here: [https://docs.apiverve.com/ref/slotmachine](https://docs.apiverve.com/ref/slotmachine?utm_source=pypi&utm_medium=referral&utm_content=readme).
You can find parameters, example responses, and status codes documented here.

### Setup

```python
# Import the client module
from apiverve_slotmachinesimulator.apiClient import SlotmachineAPIClient

# Initialize the client with your APIVerve API key
api = SlotmachineAPIClient("[YOUR_API_KEY]")
```

---

## Perform Request

Using the API client, you can perform requests to the API.

###### Define Query

```python
query = {
    "spins": 1,
    "reels": 3,
    "bet": 1
}
```

###### Simple Request

```python
# Make a request to the API
result = api.execute(query)

# Print the result
print(result)
```

###### Example Response

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

---

## Error Handling

The API client provides comprehensive error handling through the `SlotmachineAPIClientError` exception. Here are some examples:

### Basic Error Handling

```python
from apiverve_slotmachinesimulator.apiClient import SlotmachineAPIClient, SlotmachineAPIClientError

api = SlotmachineAPIClient("[YOUR_API_KEY]")

query = {
    "spins": 1,
    "reels": 3,
    "bet": 1
}

try:
    result = api.execute(query)
    print("Success!")
    print(result)
except SlotmachineAPIClientError as e:
    print(f"API Error: {e.message}")
    if e.status_code:
        print(f"Status Code: {e.status_code}")
    if e.response:
        print(f"Response: {e.response}")
```

### Handling Specific Error Types

```python
from apiverve_slotmachinesimulator.apiClient import SlotmachineAPIClient, SlotmachineAPIClientError

api = SlotmachineAPIClient("[YOUR_API_KEY]")

query = {
    "spins": 1,
    "reels": 3,
    "bet": 1
}

try:
    result = api.execute(query)

    # Check for successful response
    if result.get('status') == 'success':
        print("Request successful!")
        print(result.get('data'))
    else:
        print(f"API returned an error: {result.get('error')}")

except SlotmachineAPIClientError as e:
    # Handle API client errors
    if e.status_code == 401:
        print("Unauthorized: Invalid API key")
    elif e.status_code == 429:
        print("Rate limit exceeded")
    elif e.status_code >= 500:
        print("Server error - please try again later")
    else:
        print(f"API error: {e.message}")
except Exception as e:
    # Handle unexpected errors
    print(f"Unexpected error: {str(e)}")
```

### Using Context Manager (Recommended)

The client supports the context manager protocol for automatic resource cleanup:

```python
from apiverve_slotmachinesimulator.apiClient import SlotmachineAPIClient, SlotmachineAPIClientError

query = {
    "spins": 1,
    "reels": 3,
    "bet": 1
}

# Using context manager ensures proper cleanup
with SlotmachineAPIClient("[YOUR_API_KEY]") as api:
    try:
        result = api.execute(query)
        print(result)
    except SlotmachineAPIClientError as e:
        print(f"Error: {e.message}")
# Session is automatically closed here
```

---

## Advanced Features

### Debug Mode

Enable debug logging to see detailed request and response information:

```python
from apiverve_slotmachinesimulator.apiClient import SlotmachineAPIClient

# Enable debug mode
api = SlotmachineAPIClient("[YOUR_API_KEY]", debug=True)

query = {
    "spins": 1,
    "reels": 3,
    "bet": 1
}

# Debug information will be printed to console
result = api.execute(query)
```

### Manual Session Management

If you need to manually manage the session lifecycle:

```python
from apiverve_slotmachinesimulator.apiClient import SlotmachineAPIClient

api = SlotmachineAPIClient("[YOUR_API_KEY]")

query = {
    "spins": 1,
    "reels": 3,
    "bet": 1
}

try:
    result = api.execute(query)
    print(result)
finally:
    # Manually close the session when done
    api.close()
```

---

## Customer Support

Need any assistance? [Get in touch with Customer Support](https://apiverve.com/contact?utm_source=pypi&utm_medium=referral&utm_content=readme).

---

## Updates
Stay up to date by following [@apiverveHQ](https://twitter.com/apiverveHQ) on Twitter.

---

## Legal

All usage of the APIVerve website, API, and services is subject to the [APIVerve Terms of Service](https://apiverve.com/terms?utm_source=pypi&utm_medium=referral&utm_content=readme) and all legal documents and agreements.

---

## License
Licensed under the MIT License (MIT)

Copyright (&copy;) 2026 APIVerve, and EvlarSoft LLC

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
