package com.example.demo.service.impl;

import com.example.demo.model.DeliveryEvaluation;
import com.example.demo.model.Vendor;
import com.example.demo.model.VendorPerformanceScore;
import com.example.demo.repository.DeliveryEvaluationRepository;
import com.example.demo.repository.VendorPerformanceScoreRepository;
import com.example.demo.repository.VendorRepository;
import com.example.demo.repository.VendorTierRepository;
import com.example.demo.service.VendorPerformanceScoreService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class VendorPerformanceScoreServiceImpl
        implements VendorPerformanceScoreService {

    private final VendorPerformanceScoreRepository scoreRepo;
    private final DeliveryEvaluationRepository evalRepo;
    private final VendorRepository vendorRepo;
    private final VendorTierRepository tierRepo;

    public VendorPerformanceScoreServiceImpl(
            VendorPerformanceScoreRepository scoreRepo,
            DeliveryEvaluationRepository evalRepo,
            VendorRepository vendorRepo,
            VendorTierRepository tierRepo) {
        this.scoreRepo = scoreRepo;
        this.evalRepo = evalRepo;
        this.vendorRepo = vendorRepo;
        this.tierRepo = tierRepo;
    }

    @Override
    public VendorPerformanceScore calculateScore(Long vendorId) {

        Vendor vendor = vendorRepo.findById(vendorId)
                .orElseThrow(() -> new RuntimeException("not found"));

        List<DeliveryEvaluation> evaluations =
                evalRepo.findByVendorId(vendorId);

        double onTimePct = 0.0;
        double qualityPct = 0.0;
        double overallScore = 0.0;

        if (!evaluations.isEmpty()) {
            long total = evaluations.size();

            long onTimeCount = evaluations.stream()
                    .filter(DeliveryEvaluation::getMeetsDeliveryTarget)
                    .count();

            long qualityCount = evaluations.stream()
                    .filter(DeliveryEvaluation::getMeetsQualityTarget)
                    .count();

            onTimePct = (onTimeCount * 100.0) / total;
            qualityPct = (qualityCount * 100.0) / total;

            overallScore = (onTimePct + qualityPct) / 2.0;
        }

        VendorPerformanceScore score = new VendorPerformanceScore();
        score.setVendor(vendor);
        score.setOnTimePercentage(onTimePct);
        score.setQualityCompliancePercentage(qualityPct);
        score.setOverallScore(overallScore);
        score.setCalculatedAt(new Timestamp(System.currentTimeMillis()));

        return scoreRepo.save(score);
    }

    @Override
    public VendorPerformanceScore getLatestScore(Long vendorId) {
        List<VendorPerformanceScore> scores =
            scoreRepo.findByVendorOrderByCalculatedAtDesc(vendorId);


        if (scores.isEmpty()) {
            throw new RuntimeException("not found");
        }

        return scores.get(0);
    }

    @Override
    public List<VendorPerformanceScore> getScoresForVendor(Long vendorId) {
       return scoreRepo.findByVendorOrderByCalculatedAtDesc(vendorId);

    }
}
