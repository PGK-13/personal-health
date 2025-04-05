package org.example.service;

import org.example.pojo.result.Result;
import org.example.pojo.entity.VitalSign;

public interface VitalSignService {
    Result update(VitalSign vitalSign);
    Result list();
}
