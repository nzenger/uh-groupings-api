package edu.hawaii.its.api.configuration;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

public class FailedAnalyzer implements FailureAnalyzer{
    @Override
    public FailureAnalysis analyze(Throwable failure) {
        return new FailureAnalysis("Failed Message : \n\nRegex of password found.",failure.getMessage(),failure);
    }
}
