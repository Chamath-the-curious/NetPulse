# NetPulse

NetPulse is a lightweight Java CLI application designed to track and monitor your network usage on Windows. It provides a simple way to record daily data consumption and view historical usage directly from your terminal.

## Features

- **Daily Tracking:** Records total bytes sent and received across all network adapters.
- **Reboot Resilient:** Uses a delta-based accumulation algorithm to accurately track usage even if PowerShell counters reset after a system reboot.
- **Historical View:** Quickly see how much data you've used today or view a summary of previous days.
- **Native Performance:** Built with GraalVM Native Image for fast startup and zero-dependency execution.

## Prerequisites

- **OS:** Windows (Required for PowerShell `Get-NetAdapterStatistics` integration).
- **Java:** Java 25 or higher (to build from source).
- **GraalVM:** (Optional) For generating a native executable.

## Installation

### Quick Start (Recommended)

If you just want to use the tool without building it from source:

1.  **Download:** Go to the [GitHub Releases](https://github.com/yourusername/NetPulse/releases) page and download the latest `netpulse.exe`.
2.  **Setup Folder:** Create a folder for your CLI tools (e.g., `C:\tools\netpulse`) and move the `.exe` there.
3.  **Add to PATH:**
    *   Open the **Start Search**, type "env", and select **Edit the system environment variables**.
    *   Click **Environment Variables** in the Bottom Right.
    *   Under **System variables**, find the **Path** variable and click **Edit**.
    *   Click **New** and add the path to your folder (e.g., `C:\tools\netpulse`).
    *   Click **OK** on all windows.
4.  **Verify:** Open a new PowerShell or CMD window and type:

    ```bash
    netpulse --help
    ```

### Build from Source

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/NetPulse.git
   cd NetPulse
   ```

2. Build the JAR using Maven:
   ```bash
   ./mvnw clean package
   ```

### Generate Native Image (Recommended)

To create a fast, standalone executable:
```bash
./mvnw client:build -Pnative
```
The executable will be generated in the `target/` directory.

## Usage

NetPulse uses a subcommand-based CLI structure.

### 1. Record Usage
Logs the current network usage. It is recommended to run this periodically (e.g., via Task Scheduler) to ensure accurate tracking.
```bash
netpulse record
```

### 2. View Today's Usage
Displays the total data consumed since the start of the current day.
```bash
netpulse today
```

### 3. View Historical Usage
Shows a summary of daily usage for all recorded dates.
```bash
netpulse daily-usage
```

## Data Storage

Usage records are stored as JSON files in your home directory:
`~/Documents/NetPulse/YYYY-MM-DD.json`

## Technologies Used

- **Java 25**
- **Picocli:** For the CLI framework.
- **Jackson:** For JSON serialization/deserialization.
- **Maven:** For build automation.
- **GraalVM:** For native image compilation.

## License

[MIT](LICENSE)
