package com.sc.digital.number.scanner;

import com.sc.digital.number.scanner.exception.DigitalNumberScannerValidationException;
import com.sc.digital.number.scanner.exception.InvalidPatternException;
import com.sc.digital.number.scanner.service.DigitalNumberScannerService;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class DigitalNumberScanner {
    public static void main(String[] args) {
        DigitalNumberScanner dns = new DigitalNumberScanner();
        String file = "/SingleChunk.txt";
        List<String> numbersList = dns.scanAndPrintDigitalNumbers(file);
        numbersList.forEach(number -> System.out.println(number));
    }

    public List<String> scanAndPrintDigitalNumbers(String file) {
        DigitalNumberScannerService dnsService = new DigitalNumberScannerService();
        List<String> numbersList=null;
        try {
            numbersList = dnsService.parseFileAndDetermineNumbers(file);
        } catch (InvalidPatternException e) {
            log.error("File has invalid number pattern {}", e);
        }
        catch (DigitalNumberScannerValidationException e) {
            log.error("Invalid file, cannot be parsed {}", e);
        }
        return numbersList;
    }
}
