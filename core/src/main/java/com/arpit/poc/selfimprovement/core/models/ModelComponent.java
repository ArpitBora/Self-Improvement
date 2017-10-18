package com.arpit.poc.selfimprovement.core.models;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.ExporterOption;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;


@Model(adaptables = Resource.class, resourceType = { "weretail/components/content/heroimage" }, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = "jackson", extensions = "json", options = { @ExporterOption(name = "SerializationFeature.WRITE_DATES_AS_TIMESTAMPS", value = "true") })
public class ModelComponent {

    @Inject
    String title;

    @Inject
    String heading;

    @Inject
    String buttonLabel;

    @Inject
    String buttonLinkTo;

    @Inject
    String fileReference;

    @Inject
    @Named("sling:resourceType")
    String slingResourceType;

    public String getHeading() {
        return heading;
    }

    public String getButtonLabel() {
        return buttonLabel;
    }

    public String getButtonLinkTo() {
        return buttonLinkTo;
    }

    public String getSlingResourceType() {
        return slingResourceType;
    }

    public String getTitle() {
        return title;
    }

    public String getFileReference() {
        return fileReference;
    }
}