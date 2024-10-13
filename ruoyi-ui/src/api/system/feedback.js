import request from '@/utils/request'

// 查询反馈与处理列表
export function listFeedback(query) {
  return request({
    url: '/system/feedback/list',
    method: 'get',
    params: query
  })
}

// 查询反馈与处理详细
export function getFeedback(Id) {
  return request({
    url: '/system/feedback/' + Id,
    method: 'get'
  })
}

// 新增反馈与处理
export function addFeedback(data) {
  return request({
    url: '/system/feedback',
    method: 'post',
    data: data
  })
}

// 修改反馈与处理
export function updateFeedback(data) {
  return request({
    url: '/system/feedback',
    method: 'put',
    data: data
  })
}

// 删除反馈与处理
export function delFeedback(Id) {
  return request({
    url: '/system/feedback/' + Id,
    method: 'delete'
  })
}
