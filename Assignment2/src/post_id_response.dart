/// result : "success"
/// ids : [701,805,811]
/// errors : "none"

class PostIdResponse {
  String result;
  List<int> ids;
  String errors;

  PostIdResponse({
      this.result, 
      this.ids, 
      this.errors});

  PostIdResponse.fromJson(dynamic json) {
    result = json["result"];
    ids = json["ids"] != null ? json["ids"].cast<int>() : [];
    errors = json["errors"];
  }

  Map<String, dynamic> toJson() {
    var map = <String, dynamic>{};
    map["result"] = result;
    map["ids"] = ids;
    map["errors"] = errors;
    return map;
  }

}