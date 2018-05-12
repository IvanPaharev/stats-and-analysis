package com.telecom.statsandanalysis.logic.service.impl;

import com.telecom.statsandanalysis.logic.service.AttachmentService;
import com.telecom.statsandanalysis.persistence.dao.AttachmentDao;
import com.telecom.statsandanalysis.persistence.entity.Attachment;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by A-one on 07.05.2017.
 */
@Service
@Transactional
public class AttachmentServiceImpl extends BaseServiceImpl<Attachment, Integer> implements AttachmentService {
    private final AttachmentDao attachmentDao;

    public AttachmentServiceImpl(AttachmentDao attachmentDao) {
        super(attachmentDao);
        this.attachmentDao = attachmentDao;
    }
}
