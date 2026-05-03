package logic;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import util.JsonConfig;
import domain.AdapterStat;
import domain.DailyStat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NetworkReader {

    private static ObjectMapper mapper = JsonConfig.MAPPER;
    private static final Logger logger = Logger.getLogger(UsageRecorder.class.getName());


    public static Optional<DailyStat> readPerAdapter() {
        try {
            ProcessBuilder pb = new ProcessBuilder(
                    "powershell",
                    "-Command",
                    "Get-NetAdapterStatistics | " +
                            "Select name,receivedBytes,sentBytes | " +
                            "ConvertTo-Json"
            );

            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );

            StringBuilder json = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            List<AdapterStat> stats = mapper.readValue(
                    json.toString(),
                    new TypeReference<List<AdapterStat>>() {}
            );

            return Optional.of(new DailyStat(stats));

        } catch (IOException e) {
            logger.log(Level.SEVERE, "IO Exception: ", e);
            return Optional.empty();
        }
    }
}
